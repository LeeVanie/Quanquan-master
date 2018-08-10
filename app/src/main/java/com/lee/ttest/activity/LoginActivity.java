package com.lee.ttest.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.lee.ttest.R;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.bean.Setting;
import com.lee.ttest.common.Common;
import com.lee.ttest.utils.SharedPreferencesUtils;
import com.lee.ttest.utils.ToastUtils;

import java.io.IOException;
import java.io.ObjectInputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    public static final String TAG = "LOGINACTIVITY";
    @BindView(R.id.login_text)
    TextView loginText;
    @BindView(R.id.login_name)
    EditText loginName;
    @BindView(R.id.login_psd)
    EditText loginPsd;
    @BindView(R.id.login_login)
    Button loginLogin;

    private String loginname;
    private String loginpsd;
    private boolean mBoolean;
    
    private Context mContext;

    @Override
    protected int getresLayoutID() {
        return R.layout.login_activity;
    }

    @Override
    protected void initInjecter() {
        ButterKnife.bind(this);
        loginLogin.setOnClickListener(this);

        mContext = this;

        // 登录页不开启手势
        disablePatternLock(true);

    }


    @Override
    protected void initEventAndData() {
        mBoolean = SharedPreferencesUtils.getBoolean(this, "ISLOGIN", false);
        loginname = SharedPreferencesUtils.getString(this, "loginname", "");
        loginpsd = SharedPreferencesUtils.getString(this, "loginpsd", "");
        loginName.setText(loginname);
        if (mBoolean){
            Common.ISLOGIN = mBoolean;
            loginPsd.setText(loginpsd);
            startActivity(new Intent(this, MainActivity.class));
        } else {
            Common.ISLOGIN = mBoolean;
        }
    }


    public boolean isLogin() {
        String name = loginName.getText().toString().trim();
        String psd = loginPsd.getText().toString().trim();
        if (!"".equals(name) && !"".equals(psd)) {
            if (!loginname.equals(name)) {
                ToastUtils.showToast(this, "小主...登录名错误啦啦啦...");
                return false;
            }
            if (!loginpsd.equals(psd)) {
                ToastUtils.showToast(this, "小主...密码错误啦啦啦...");
                return false;
            }
            if (loginname.equals(name) && loginpsd.equals(psd)) {
                return true;
            }
        } else {
            ToastUtils.showToast(this, "小主...你还填完整再点我吧...");
            return false;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_login:
                if (isLogin()) {
                    startActivity(new Intent(this, MainActivity.class));
                    Common.ISLOGIN = true;
                    SharedPreferencesUtils.setBoolean(this, "ISLOGIN", true);
                    finish();
                } else {
                    return;
                }
                break;
        }
    }

    //记录用户首次点击返回键的时间
    private long firstTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - firstTime > 2000) {
                Toast.makeText(this, "小主...你忍心关闭我吗...", Toast.LENGTH_SHORT).show();
                firstTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 读取手势设置
     *
     * @return
     */
    private Setting loadSettings() {
        Setting setting = null;
        try {
            ObjectInputStream in = new ObjectInputStream(mContext.openFileInput("setting.txt"));
            setting = (Setting) in.readObject();
            in.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return setting;
    }
    
}
//jhfghfh