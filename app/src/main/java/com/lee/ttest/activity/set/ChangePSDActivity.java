package com.lee.ttest.activity.set;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lee.ttest.R;
import com.lee.ttest.application.MyApplication;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.utils.SharedPreferencesUtils;
import com.lee.ttest.utils.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class ChangePSDActivity extends BaseActivity {
    private static final String TAG = ChangePSDActivity.class.getSimpleName();
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ic_title)
    TextView icTitle;
    @BindView(R.id.more)
    TextView more;
    @BindView(R.id.old_psd)
    EditText oldPsd;
    @BindView(R.id.new_psd)
    EditText newPsd;
    @BindView(R.id.qrnew_psd)
    EditText qrnewPsd;
    @BindView(R.id.login_login)
    Button loginLogin;

    private Context mContext;
    private String oldPassword;
    private String newPassword;
    private String QrnewPassword;
    
    
    @Override
    protected void initEventAndData() {
        
    }

    @Override
    protected void initInjecter() {
        mContext = this;
        icTitle.setText("密码修改");
        more.setVisibility(View.GONE);
    }

    @Override
    protected int getresLayoutID() {
        return R.layout.activity_sub;
    }

    
    @OnClick({R.id.back, R.id.login_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.login_login:
                saveChangePsd();
                break;
        }
    }

    private void saveChangePsd() {
        String loginpsd = SharedPreferencesUtils.getString(this, "loginpsd", "");
        oldPassword = oldPsd.getText().toString().trim();
        newPassword = newPsd.getText().toString().trim();
        QrnewPassword = qrnewPsd.getText().toString().trim();
        if (TextUtils.isEmpty(oldPassword)) {
            ToastUtils.showToast(this, "旧密码不可为空");
            return;
        }
        if (TextUtils.isEmpty(newPassword)) {
            ToastUtils.showToast(this, "新密码不可为空");
            return;
        }
        if (TextUtils.isEmpty(QrnewPassword)) {
            ToastUtils.showToast(this, "请再次输入新密码");
            return;
        }
        if (!newPassword.equals(QrnewPassword)) {
            ToastUtils.showToast(this, "两次新密码不对");
            return;
        }
        if (!loginpsd.equals(oldPassword)){
            ToastUtils.showToast(this, "旧密码输错啦");
            return;
        }
        
        SharedPreferencesUtils.deletedDatas(this, "loginpsd");
        SharedPreferencesUtils.saveString(this, "loginpsd", newPassword);
        SharedPreferencesUtils.setBoolean(this, "ISLOGIN", false);
        MyApplication.getApplication().finishActivity();
        restartApplication();
    }

    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    private void restartApplication() {
        final Intent intent = mContext.getPackageManager().getLaunchIntentForPackage(mContext.getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }
}
