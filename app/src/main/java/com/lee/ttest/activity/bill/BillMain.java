package com.lee.ttest.activity.bill;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.lee.ttest.R;
import com.lee.ttest.adapter.BillMainAdapter;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.db.BillBean;
import com.lee.ttest.db.BillBeanDao;
import com.lee.ttest.db.GreenDaoUtils;

import java.util.List;

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
public class BillMain extends BaseActivity {
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ic_title)
    TextView icTitle;
    @BindView(R.id.more)
    TextView more;
    @BindView(R.id.anim_layout)
    LinearLayout animLayout;
    @BindView(R.id.listview)
    ListView listview;
    @BindView(R.id.no_datas)
    LinearLayout noDatas;

    private List<BillBean> mBeanList;
    private BillBeanDao mBillBeanDao;
    private BillMainAdapter mAdapter;


    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mBeanList = mBillBeanDao.queryBuilder().where(BillBeanDao.Properties.BillTag.eq("tag")).orderDesc(BillBeanDao
                .Properties.Datas).list();

        if (mBeanList.size() > 0) {
            noDatas.setVisibility(View.GONE);
            listview.setVisibility(View.VISIBLE);
            mAdapter = new BillMainAdapter(mBeanList, this);
            listview.setAdapter(mAdapter);
        } else {
            listview.setVisibility(View.GONE);
            noDatas.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void initInjecter() {
        icTitle.setText("账单");
        //        animLayout.setBackgroundDrawable(getResources().getDrawable(R.mipmap.sc_lightspot));
        mBillBeanDao = GreenDaoUtils.getSingleTon().getmDaoSession().getBillBeanDao();
    }

    @Override
    protected int getresLayoutID() {
        return R.layout.bill_main;
    }

    @OnClick({R.id.back, R.id.more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                onBackPressed();
                break;
            case R.id.more:
                Intent intent = new Intent(this, BillSelectedType.class);
                intent.putExtra("FLAG", "NEW");
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
//jhfghfh