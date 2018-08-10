package com.lee.ttest.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lee.ttest.R;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.utils.CodeUtils;
import com.lee.ttest.utils.SharedPreferencesUtils;
import com.lee.ttest.utils.ToastUtils;

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
public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.et)
    EditText et;
    @BindView(R.id.btn)
    TextView btn;
    @BindView(R.id.btn_submit)
    TextView btnSubmit;
    @BindView(R.id.register_name)
    EditText registerName;
    @BindView(R.id.register_psd)
    EditText registerPsd;
    private String codeStr;
    
    private String name, psd;
    
    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void initInjecter() {
        btn.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
        Bitmap bitmap = CodeUtils.getInstance().createBitmap();
        image.setImageBitmap(bitmap);
    }

    @Override
    protected int getresLayoutID() {
        return R.layout.register_activity;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                Bitmap bitmap = CodeUtils.getInstance().createBitmap();
                image.setImageBitmap(bitmap);
                break;
            case R.id.btn_submit:
                if (isRegister() && yanzhengma()) {
                    name = registerName.getText().toString().trim();
                    psd = registerPsd.getText().toString().trim();
                    SharedPreferencesUtils.saveString(this, "loginname", name);
                    SharedPreferencesUtils.saveString(this, "loginpsd", psd);
                    startActivity(new Intent(this, LoginActivity.class));
                    finish();
                }else {
                    return;
                }
                break;
        }
    }

    public boolean yanzhengma() {
        codeStr = et.getText().toString().trim();
        Log.e("codeStr", codeStr);
        if (null == codeStr || TextUtils.isEmpty(codeStr)) {
            Toast.makeText(this, "请输入验证码", 0).show();
            return false;
        }
        String code = CodeUtils.getInstance().getCode();
        Log.e("code", code);
        if (code.equalsIgnoreCase(codeStr)) {
            Toast.makeText(this, "验证码正确", 0).show();
            return true;
        } else {
            Toast.makeText(this, "验证码错误", 0).show();
            et.setText("");
            return false;
        }
    }


    public boolean isRegister(){
        if (!"".equals(registerName.getText().toString().trim()) && !"".equals(registerPsd.getText().toString().trim())){
            return true;
        } else {
            ToastUtils.showToast(this, "小主...你还是填完整再点我吧...");
            return false;
        }
    }
}
//jhfghfh