package com.lee.ttest.activity.bill;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lee.ttest.R;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.common.Common;
import com.lee.ttest.utils.LocationAddress;
import com.lee.ttest.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class BillRemark extends BaseActivity {
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.content)
    EditText content;
    @BindView(R.id.location)
    ImageView location;
    @BindView(R.id.location_text)
    TextView locationText;
    @BindView(R.id.commit)
    TextView commit;

    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void initInjecter() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        
        locationText.setText(Common.getInstense().getADDRESS());
    }

    @Override
    protected int getresLayoutID() {
        return R.layout.bill_remark;
    }

    @OnClick({R.id.back, R.id.location, R.id.commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.location:
                
                if (!"".equals(Common.getInstense().getADDRESS()) && null != Common.getInstense().getADDRESS()) {
                    locationText.setText(Common.getInstense().getADDRESS());
                } else {
                    ToastUtils.showToast(this, "检查是否给了权限或者是否联网");
                }
                break;
            case R.id.commit:
                String s = locationText.getText().toString().trim();
                if (null == s){
                    s = "";
                }
                if (!"".equals(s)) {
                    Common.REMARK =  "备注：" + content.getText().toString().trim() + "\t地址：" + s;
                } else {
                    Common.REMARK = "备注：" + content.getText().toString().trim();
                }
                finish();
                break;
        }
    }
}
//jhfghfh