package com.lee.ttest.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.lee.ttest.R;
import com.lee.ttest.activity.BjnewDetailsActivity;
import com.lee.ttest.adapter.BjnewListAdapter;
import com.lee.ttest.application.MyApplication;
import com.lee.ttest.base.BaseFragment;
import com.lee.ttest.bean.BjNewListBean;
import com.lee.ttest.mvp.presenter.BjnewPresenter;
import com.lee.ttest.mvp.presenter.BjnewPresenterImpl;
import com.lee.ttest.mvp.view.BjnewListView;
import com.lee.ttest.widget.GifLoadingView;
import com.lee.ttest.widget.PullToRefreshLayout;
import com.lee.ttest.widget.PullableListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class BjNewFragment extends BaseFragment implements BjnewListView, PullToRefreshLayout.OnRefreshListener {

    @BindView(R.id.head_view)
    RelativeLayout headView;
    @BindView(R.id.content_view)
    PullableListView mList;
    @BindView(R.id.loadmore_view)
    RelativeLayout loadmoreView;
    @BindView(R.id.refresh_view)
    PullToRefreshLayout refreshView;
    @BindView(R.id.no_datas)
    LinearLayout noDatas;
    Unbinder unbinder;
    @BindView(R.id.fabfragmentmainlist)
    FloatingActionButton fabfragmentmainlist;
    @BindView(R.id.main_content)
    RelativeLayout mainContent;

    private int flag = 0;
    private String type;
    private boolean scrollFlag = false;
    private int lastVisibleItemPosition = 0;// 标记上次滑动位置  
    private BjnewPresenter mPresenter;
    private BjnewListAdapter adapter;
    private List<BjNewListBean.ResultBeanX.ResultBean.ListBean> databean;

    public static BjNewFragment getInstence(String type) {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        BjNewFragment fragment = new BjNewFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getContentViewResID() {
        return R.layout.bjnew_fragment;
    }

    /**
     * 初始化FloatActionButton
     */
    private void initFab() {
        fabfragmentmainlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 8) {
                    mList.smoothScrollToPosition(0);
                } else {
                    mList.setSelection(0);
                }
            }
        });
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
    protected void initViews() {
        
        type = getArguments().getString("type");
        initFab();
        databean = new ArrayList<>();

        mPresenter = new BjnewPresenterImpl(this);
        refreshView.setOnRefreshListener(this);
        noDatas.setVisibility(View.GONE);
        refreshView.setVisibility(View.VISIBLE);

        adapter = new BjnewListAdapter(getActivity());
        mList.setAdapter(adapter);
       
        refreshView.autoRefresh();
    }
    
    @Override
    protected void initDatas() {
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BjNewListBean.ResultBeanX.ResultBean.ListBean dataBean = (BjNewListBean.ResultBeanX.ResultBean.ListBean) parent.getItemAtPosition(position);
                Intent intent = new Intent(getActivity(), BjnewDetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("BjNewListBean", dataBean);
                bundle.putString("FLAG", "new");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    
    @Override
    public void showDatas(BjNewListBean.ResultBeanX.ResultBean bean) {
        try {
            refreshView.refreshFinish(PullToRefreshLayout.SUCCEED);
        } catch (Exception e){
            e.printStackTrace();
        }
        if (bean.getList().size() != 0) {
            noDatas.setVisibility(View.GONE);
            mList.setVisibility(View.VISIBLE);
        } else {
            noDatas.setVisibility(View.VISIBLE);
            mList.setVisibility(View.GONE);
            return;
        }
        
        if (flag == 0){
            databean.clear();
        }
        
        databean.addAll(bean.getList());
        adapter.setDataBeen(databean);

    }
    
    @Override
    public void showFailed() {
        try {
            refreshView.refreshFinish(PullToRefreshLayout.SUCCEED);
        } catch (Exception e){
            e.printStackTrace();
        }
        noDatas.setVisibility(View.VISIBLE);
        mList.setVisibility(View.GONE);
    }

    @Override
    public void onRefresh(final PullToRefreshLayout pullToRefreshLayout) {
        flag = 0;
        mPresenter.setDatas(getActivity(), type, flag);
    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        flag = 1;
        mPresenter.setDatas(getActivity(), type, flag);
    }
}
//jhfghfh