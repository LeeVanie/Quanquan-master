package com.lee.ttest.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lee.ttest.R;
import com.lee.ttest.adapter.BjSreachAdapter;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.bean.BjSreachBean;
import com.lee.ttest.mvp.presenter.BjnewSreachPresenterImpl;
import com.lee.ttest.mvp.view.BjnewSreachView;
import com.lee.ttest.widget.GifLoadingView;

import java.util.ArrayList;
import java.util.List;

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
public class BjSreachActivity extends BaseActivity implements BjnewSreachView {
    @BindView(R.id.back)
    TextView back;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.main_title)
    LinearLayout mainTitle;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.no_datas)
    LinearLayout noDatas;
    @BindView(R.id.fabfragmentmainlist)
    FloatingActionButton fabfragmentmainlist;

    private LinearLayoutManager layoutManager;
    private BjSreachAdapter mAdapter;
    private BjnewSreachPresenterImpl mPresenter;
    private GifLoadingView mGifLoadingView;
    @Override
    protected void initEventAndData() {
        
    }

    @Override
    protected void initInjecter() {
        title.setText("新闻列表");
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        
        mAdapter = new BjSreachAdapter(this);
        mAdapter.setOnItemClickListener(new BjSreachAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position, BjSreachBean.ResultBeanX.ResultBean.ListBean bean) {
                Intent intent = new Intent(BjSreachActivity.this, BjnewDetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("BjNewListBean", bean);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        mGifLoadingView = new GifLoadingView((ViewGroup) findViewById(R.id.main_content).getRootView(), this,
                "正在加载中......");
        mPresenter = new BjnewSreachPresenterImpl(this);
        
        mPresenter.setDatas(this, getIntent().getStringExtra("KEY"));
        
        recyclerView.setAdapter(mAdapter);
    }
   
    @Override
    protected int getresLayoutID() {
        return R.layout.activity_refresh;
    }

    @Override
    public void showDatas(BjSreachBean.ResultBeanX.ResultBean bean) {
        mGifLoadingView.dismiss();
        recyclerView.setVisibility(View.VISIBLE);
        noDatas.setVisibility(View.GONE);
        mAdapter.setListBeans(bean.getList());
    }

    @Override
    public void showFailed() {
        mGifLoadingView.dismiss();
        noDatas.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }
}
