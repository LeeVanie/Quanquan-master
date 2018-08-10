package com.lee.ttest.activity.bill;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lee.ttest.R;
import com.lee.ttest.adapter.BillDetailsAdapter;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.db.BillBean;
import com.lee.ttest.db.BillBeanDao;
import com.lee.ttest.db.GreenDaoUtils;
import com.lee.ttest.widget.MyListView;

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
public class BillDetails extends BaseActivity {
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ic_title)
    TextView icTitle;
    @BindView(R.id.more)
    TextView more;
    @BindView(R.id.anim_layout)
    LinearLayout animLayout;
    @BindView(R.id.shou_money)
    TextView shouMoney;
    @BindView(R.id.chu_money)
    TextView chuMoney;
    @BindView(R.id.total_money)
    TextView totalMoney;
    @BindView(R.id.shou_list)
    MyListView shouList;
    @BindView(R.id.chu_list)
    MyListView chuList;

    private BillBean mBean;
    private BillBeanDao mBillBeanDao;
    private String DATA;
    private BillDetailsAdapter shouAdapter;
    private BillDetailsAdapter chuAdapter;
    
    @Override
    protected void initEventAndData() {
        
    }
        
    @Override
    protected void initInjecter() {
        DATA = getIntent().getExtras().getString("DATA");
        more.setText("添加");
        more.setTextSize(17);
    }

    @Override
    protected int getresLayoutID() {
        return R.layout.bill_details;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBillBeanDao = GreenDaoUtils.getSingleTon().getmDaoSession().getBillBeanDao();
        double sshou = 0, cchu = 0;
        mBean = mBillBeanDao.queryBuilder().where(BillBeanDao.Properties.Datas.eq(DATA)).unique();
        icTitle.setText(mBean.getDatas() + "账单详情");
        String[]  shou = mBean.getBillShouContent().split("#");
        if (shou.length >0 ){
            for (int i = 0; i < shou.length; i++) {
                String[] s = shou[i].split("@");
                if (!"".equals(s[0])) {
                    sshou += Float.valueOf(s[0]).floatValue();
                }
            }
            shouMoney.setText(sshou + "");
        }
        String[]  chu = mBean.getBillChuContent().split("#");
        if (chu.length >0 ){
            for (int i = 0; i < chu.length; i++) {
                String[] s = chu[i].split("@");
                if (!"".equals(s[0])) {
                    cchu += Float.valueOf(s[0]).floatValue();
                }
            }
            chuMoney.setText(cchu + "");    
        }
        totalMoney.setText((sshou - cchu) + "");
        
        shouAdapter = new BillDetailsAdapter(mBean.getBillShouContent(), this, "SHOU");
        shouList.setAdapter(shouAdapter);
        chuAdapter = new BillDetailsAdapter(mBean.getBillChuContent(), this, "CHU");
        chuList.setAdapter(chuAdapter);
    }

    @OnClick({R.id.back, R.id.more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.more:
                Intent intent = new Intent(this, BillSelectedType.class);
                intent.putExtra("DATA", mBean.getDatas());
                intent.putExtra("TYPE", mBean.getBillType());
                intent.putExtra("SHOUCONTENT", mBean.getBillShouContent());
                intent.putExtra("CHUCONTENT", mBean.getBillChuContent());
                startActivity(intent);
                finish();
                break;
        }
    }
}
//jhfghfh