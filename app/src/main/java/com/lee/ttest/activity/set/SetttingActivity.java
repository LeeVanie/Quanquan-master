package com.lee.ttest.activity.set;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.lee.ttest.R;
import com.lee.ttest.activity.MainActivity;
import com.lee.ttest.application.MyApplication;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.bean.Setting;
import com.lee.ttest.common.Config;

import butterknife.BindView;

public class SetttingActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int REQUEST_CODE_LOCK = 1;
    @BindView(R.id.btn_to_set_lock)
    Button btnToLock;
    @BindView(R.id.switch_main_show_path)
    Switch swShowPath;
    @BindView(R.id.rl_main_show_path)
    RelativeLayout rlShowPath;
    @BindView(R.id.btn_to_sub_activity)
    Button btnToSub;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ic_title)
    TextView icTitle;
    @BindView(R.id.more)
    TextView more;

    private Context mContext;
    private MyApplication myApp;


    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void initInjecter() {
        setTitle("主页");
        mContext = this;

        myApp = MyApplication.getApplication();
        more.setVisibility(View.GONE);
        icTitle.setText("安全中心");
        initView();

        // 初始化页面状态
        changeStatus();
    }

    @Override
    protected int getresLayoutID() {
        return R.layout.activity_setting;
    }

    private void initView() {

        btnToLock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toSetLock();
            }
        });
        btnToSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, ChangePSDActivity.class));

            }
        });
        swShowPath.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (myApp.getSettings() != null) {
                    myApp.getSettings().setShowPath(isChecked ? Setting.SHOW_PATH : Setting.HIDE_PATH);
                    savePattern();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void toSetLock() {
        Intent intent;
        if (myApp.getSettings() == null || "".equals(myApp.getSettings().getGesture())) {
            intent = new Intent(mContext, LockOnActivity.class);
        } else {
            intent = new Intent(mContext, LockOffActivity.class);
        }
        startActivityForResult(intent, REQUEST_CODE_LOCK);
    }

    private void changeStatus() {
        if (myApp.getSettings() == null || "".equals(myApp.getSettings().getGesture())) {
            btnToLock.setText("设置手势密码");
            rlShowPath.setVisibility(View.GONE);
        } else {
            btnToLock.setText("取消手势密码");
            rlShowPath.setVisibility(View.VISIBLE);
            swShowPath.setChecked(!Setting.HIDE_PATH.equals(myApp.getSettings().getShowPath()));
        }
    }

    /**
     * 存手势设置
     */
    private void savePattern() {
        Config.setGestureSettings(myApp.getSettings());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            changeStatus();
            savePattern();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 不置零的效果是，如果在设定的一分钟之内再次打开APP则不会弹出手势密码
        // 因为应用的Activity全部finish后Application可能还存在
        // 这句置零代码也可以放在启动APP页面onResume()方法之前
        myApp.setLockTime(0);
    }

}
