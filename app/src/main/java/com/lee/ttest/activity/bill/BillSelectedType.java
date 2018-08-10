package com.lee.ttest.activity.bill;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lee.ttest.R;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.db.BillBean;
import com.lee.ttest.db.BillBeanDao;
import com.lee.ttest.utils.Date_U;
import com.lee.ttest.widget.CoustomCheckTimePickerView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class BillSelectedType extends BaseActivity {
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ic_title)
    TextView icTitle;
    @BindView(R.id.data)
    TextView data;
    @BindView(R.id.shou)
    TextView shou;
    @BindView(R.id.chu)
    TextView chu;
    @BindView(R.id.first_page)
    LinearLayout firstPage;
    
    private String FLAG;
    private int[] imgs ;
    private int[] imgSelected;
    private String[] texts;
    private BillBean mBillBean;
    private BillBeanDao mBillBeanDao;
    private String DATA;
    private String TYPE;
    private String SHOUCONTENT;
    private String CHUCONTENT;
//    private BillMapBean map;
    
    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void initInjecter() {
        FLAG = getIntent().getExtras().getString("FLAG");
        DATA = getIntent().getExtras().getString("DATA");
        TYPE = getIntent().getExtras().getString("TYPE");
        SHOUCONTENT = getIntent().getExtras().getString("SHOUCONTENT");
        CHUCONTENT = getIntent().getExtras().getString("CHUCONTENT");
//        map = (BillMapBean) getIntent().getExtras().getSerializable("LIST");
        if ("NEW".equals(FLAG)) {
            data.setText(Date_U.getCurrentTime());
        } else {
            data.setText(DATA);
        }
    }

    @Override
    protected int getresLayoutID() {
        return R.layout.bill_select_new;
    }

    @OnClick({R.id.back, R.id.data, R.id.shou, R.id.chu})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.back:
                intent = new Intent(this, BillDetails.class);
                intent.putExtra("DATA", DATA);
                startActivity(intent);
                finish();
                break;
            case R.id.data:
                if ("NEW".equals(FLAG)) {
                    CoustomCheckTimePickerView.getInstance().getRqTime(this, data);
                }
                break;
            case R.id.shou:
                String time = data.getText().toString().trim();
                intent = new Intent(this, BillNew.class);
                intent.putExtra("DATA", time);
                intent.putExtra("TYPE", "收");
                if ("NEW".equals(FLAG)) {
                    intent.putExtra("SHOUCONTENT", "");
                    intent.putExtra("CHUCONTENT", "");
                } else {
                    intent.putExtra("SHOUCONTENT", SHOUCONTENT);
                    intent.putExtra("CHUCONTENT", CHUCONTENT);
                }
                startActivity(intent);
                finish();
                break;
            case R.id.chu:
                String t = data.getText().toString().trim();
                intent = new Intent(this, BillNew.class);
                intent.putExtra("DATA", t);
                intent.putExtra("TYPE", "出");
                if ("NEW".equals(FLAG)) {
                    intent.putExtra("SHOUCONTENT", "");
                    intent.putExtra("CHUCONTENT", "");
                } else {
                    intent.putExtra("SHOUCONTENT", SHOUCONTENT);
                    intent.putExtra("CHUCONTENT", CHUCONTENT);
                }
                startActivity(intent);
                finish();
                break;
        }
    }
}
//jhfghfh