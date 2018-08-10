package com.lee.ttest.activity.lssdjt;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.lee.ttest.R;
import com.lee.ttest.activity.BsbdjListActivity;
import com.lee.ttest.adapter.HistoryAdapter;
import com.lee.ttest.application.MyApplication;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.bean.HistoryBean;
import com.lee.ttest.calendar.bean.DateEntity;
import com.lee.ttest.calendar.view.DataView;
import com.lee.ttest.mvp.presenter.HistoryPresenter;
import com.lee.ttest.mvp.presenter.HistoryPresenterImpl;
import com.lee.ttest.mvp.view.HistoryView;
import com.lee.ttest.utils.Date_U;
import com.lee.ttest.widget.GifLoadingView;

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
public class HistoryActivity extends BaseActivity implements HistoryView, View.OnClickListener {
    @BindView(R.id.back)
    TextView back;
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.listview)
    ListView mList;
    @BindView(R.id.no_datas)
    LinearLayout noDatas;
    @BindView(R.id.add)
    TextView add;
    @BindView(R.id.week)
    DataView dataView;
    @BindView(R.id.fabfragmentmainlist)
    FloatingActionButton fabfragmentmainlist;

    private String month;
    private String day;
    private GifLoadingView gifLoadingView;
    private HistoryPresenter mPresenter;
    private HistoryAdapter mHistoryAdapter;
    private int lastVisibleItemPosition = 0;// 标记上次滑动位置  
    private boolean scrollFlag = false;


    @Override
    protected void initEventAndData() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HistoryBean.ResultBean bean = (HistoryBean.ResultBean) parent.getItemAtPosition(position);
                Intent intent = new Intent(HistoryActivity.this, HistoryDetailsActivity.class);
                intent.putExtra("ID", bean.get_id());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initInjecter() {
        mTitle.setText("历史上的今天");
        gifLoadingView = new GifLoadingView((ViewGroup) findViewById(R.id.main_content).getRootView(), this, "正在为您加载....");
        gifLoadingView.setCanceledOnTouchOutside(true);
        mPresenter = new HistoryPresenterImpl(this);

        String today = Date_U.getCurrentTime();
        dataView.setOnSelectListener(new DataView.OnSelectListener() {
            @Override
            public void onSelected(DateEntity date) {
                String[] dataStr = date.date.split("-");
                month = dataStr[1];
                day = dataStr[2];
                
                mHistoryAdapter = new HistoryAdapter(HistoryActivity.this);
                mList.setAdapter(mHistoryAdapter);
                HistoryBean bean = new HistoryBean();
                bean = (HistoryBean) MyApplication.ACACHE.getAsObject("HistoryBean" + month + day);
                if (bean != null && bean.getResult().size() > 0){
                    mHistoryAdapter.setBeanList(bean.getResult());
                }
                
                gifLoadingView.show();
                mPresenter.setDatas(HistoryActivity.this, month, day);
               
            }
        });

       

        dataView.getData(today);
        initFab();
    }

    /**
     * 初始化FloatActionButton
     */
    private void initFab() {
        fabfragmentmainlist.setOnClickListener(this);
        mList.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                //判断状态  
                switch (scrollState) {
                    // 当不滚动时  
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:// 是当屏幕停止滚动时  
                        scrollFlag = false;
                        // 判断滚动到底部 、position是从0开始算起的  
                        if (mList.getLastVisiblePosition() == (mList.getCount() - 1)) {
                            fabfragmentmainlist.show();
                        }
                        // 判断滚动到顶部  
                        if (mList.getFirstVisiblePosition() == 0) {
                            fabfragmentmainlist.hide();
                        }
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:// 滚动时  
                        scrollFlag = true;
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_FLING:
                        // 当用户由于之前划动屏幕并抬起手指，屏幕产生惯性滑动时，即滚动时  
                        scrollFlag = true;
                        break;
                }
            }
            /**
             * firstVisibleItem：当前能看见的第一个列表项ID（从0开始） 
             * visibleItemCount：当前能看见的列表项个数（小半个也算） totalItemCount：列表项共数 
             */
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                //当滑动时  
                if (scrollFlag) {
                    if (firstVisibleItem < lastVisibleItemPosition) {
                        // 上滑  
                        fabfragmentmainlist.show();
                    } else if (firstVisibleItem > lastVisibleItemPosition) {
                        // 下滑  
                        fabfragmentmainlist.hide();
                    } else {
                        return;
                    }
                    lastVisibleItemPosition = firstVisibleItem;//更新位置  
                }
            }
        });
    }

    @Override
    protected int getresLayoutID() {
        return R.layout.lssdjt;
    }
    
    private boolean SAVE = true;
    
    @Override
    public void showDatas(HistoryBean beanList) {
        gifLoadingView.dismiss();
        if (beanList.getResult().size() > 0) {
            noDatas.setVisibility(View.GONE);
            mList.setVisibility(View.VISIBLE);
            mHistoryAdapter = new HistoryAdapter(this);
            mList.setAdapter(mHistoryAdapter);
            mHistoryAdapter.setBeanList(beanList.getResult());
            MyApplication.ACACHE.put("HistoryBean" + month + day, beanList);
            HistoryBean bean = (HistoryBean) MyApplication.ACACHE.getAsObject("HistoryBean" + month + day);
        } else {
            noDatas.setVisibility(View.VISIBLE);
            mList.setVisibility(View.GONE);
        }
    }

    @Override
    public void showFailed() {
        gifLoadingView.dismiss();
        noDatas.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        if (v == fabfragmentmainlist) {
            if (android.os.Build.VERSION.SDK_INT >= 8) {
                mList.smoothScrollToPosition(0);
            } else {
                mList.setSelection(0);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        gifLoadingView = null;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
//jhfghfh