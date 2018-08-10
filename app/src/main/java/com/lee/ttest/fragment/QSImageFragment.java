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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lee.ttest.R;
import com.lee.ttest.activity.BjnewDetailsActivity;
import com.lee.ttest.activity.BsbdjImageActivity;
import com.lee.ttest.adapter.QSImageApapter;
import com.lee.ttest.application.MyApplication;
import com.lee.ttest.base.BaseFragment;
import com.lee.ttest.base.HomeKeyWatcher;
import com.lee.ttest.bean.QSImageBean;
import com.lee.ttest.bean.QSTextBean;
import com.lee.ttest.mvp.presenter.QSImageListPresenter;
import com.lee.ttest.mvp.presenter.QSImageListPresenterImpl;
import com.lee.ttest.mvp.presenter.QSTextListPresenter;
import com.lee.ttest.mvp.presenter.QSTextListPresenterImpl;
import com.lee.ttest.mvp.view.QsImageView;
import com.lee.ttest.mvp.view.QsTextView;
import com.lee.ttest.widget.GifLoadingView;
import com.lee.ttest.widget.PullToRefreshLayout;
import com.lee.ttest.widget.PullableListView;

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
public class QSImageFragment extends BaseFragment implements QsImageView, PullToRefreshLayout
        .OnRefreshListener {
    @BindView(R.id.pull_icon)
    ImageView pullIcon;
    @BindView(R.id.refreshing_icon)
    ImageView refreshingIcon;
    @BindView(R.id.state_tv)
    TextView stateTv;
    @BindView(R.id.state_iv)
    ImageView stateIv;
    @BindView(R.id.head_view)
    RelativeLayout headView;
    @BindView(R.id.content_view)
    PullableListView mList;
    @BindView(R.id.pullup_icon)
    ImageView pullupIcon;
    @BindView(R.id.loading_icon)
    ImageView loadingIcon;
    @BindView(R.id.loadstate_tv)
    TextView loadstateTv;
    @BindView(R.id.loadstate_iv)
    ImageView loadstateIv;
    @BindView(R.id.loadmore_view)
    RelativeLayout loadmoreView;
    @BindView(R.id.refresh_view)
    PullToRefreshLayout refreshView;
    @BindView(R.id.no_datas)
    LinearLayout noDatas;
    @BindView(R.id.fabfragmentmainlist)
    FloatingActionButton fabfragmentmainlist;
    @BindView(R.id.main_content)
    RelativeLayout mainContent;
    @BindView(R.id.main)
    LinearLayout main;
    Unbinder unbinder;

    private int pageToken = 1;
    private QSImageListPresenter mPresenter;
    private int lastVisibleItemPosition = 0;// 标记上次滑动位置  
    private boolean scrollFlag = false;
    private List<QSImageBean.ShowapiResBodyBean.ContentlistBean> mDataBeen;
    private QSImageApapter mApapter;
    
    public static QSImageFragment getInstence(int type) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        QSImageFragment fragment = new QSImageFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getContentViewResID() {
        return R.layout.bsbdj;
    }

    @Override
    protected void initViews() {
        refreshView.setOnRefreshListener(this);
        noDatas.setVisibility(View.GONE);
        refreshView.setVisibility(View.VISIBLE);
        initFab();

        mApapter = new QSImageApapter(getActivity(), "2");
        mList.setAdapter(mApapter);

        QSImageBean bean = new QSImageBean();
        bean = (QSImageBean) MyApplication.ACACHE.getAsObject("QSImageBean");
        if (bean != null && bean.getShowapi_res_body().getContentlist().size() > 0){
            mApapter.setDataBeen(bean.getShowapi_res_body().getContentlist());
        }

        mDataBeen = new ArrayList<>();
        refreshView.autoRefresh();
        mPresenter = new QSImageListPresenterImpl(this);
    }

    @Override
    protected void initDatas() {
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                QSImageBean.ShowapiResBodyBean.ContentlistBean bean = 
                        (QSImageBean.ShowapiResBodyBean.ContentlistBean) parent.getItemAtPosition(position);
                Intent intent = new Intent(getActivity(), BsbdjImageActivity.class);
                intent.putExtra("imgUrl", bean.getImg());
                startActivity(intent);
            }
        });
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

    private boolean SAVE = true;
    @Override
    public void showDatas(QSImageBean bean) {
        refreshView.refreshFinish(PullToRefreshLayout.SUCCEED);
        mDataBeen.addAll(bean.getShowapi_res_body().getContentlist());

        if (mDataBeen.size() == 0) {
            noDatas.setVisibility(View.VISIBLE);
            refreshView.setVisibility(View.GONE);
            return;
        } else {
            noDatas.setVisibility(View.GONE);
            refreshView.setVisibility(View.VISIBLE);
        }

        mApapter.setDataBeen(mDataBeen);

        if (SAVE){
            MyApplication.ACACHE.remove("QSImageBean");
            MyApplication.ACACHE.put("QSImageBean", bean);
            SAVE = false;
        }
    }

    @Override
    public void showFailed() {
        refreshView.refreshFinish(PullToRefreshLayout.FAIL);
        noDatas.setVisibility(View.VISIBLE);
        refreshView.setVisibility(View.GONE);
        refreshView.refreshFinish(PullToRefreshLayout.SUCCEED);
    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        pageToken = 1;
        mPresenter.setDatas(getActivity(), "2", pageToken + "");
    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        pageToken ++;
        mPresenter.setDatas(getActivity(), "2", pageToken + "");
    }
}
//jhfghfh