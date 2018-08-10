package com.lee.ttest.fragment;

import android.content.Intent;
import android.os.AsyncTask;
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
import android.widget.Toast;

import com.lee.ttest.R;
import com.lee.ttest.activity.BsbdjImageActivity;
import com.lee.ttest.activity.BsbdjListActivity;
import com.lee.ttest.adapter.BsbdjApapter;
import com.lee.ttest.application.MyApplication;
import com.lee.ttest.base.BaseFragment;
import com.lee.ttest.base.HomeKeyWatcher;
import com.lee.ttest.bean.BsbdjDetailsBean;
import com.lee.ttest.bean.BsbdjListBean;
import com.lee.ttest.mvp.presenter.BsbdjDetailsPresenter;
import com.lee.ttest.mvp.presenter.BsbdjDetailsPresenterImpl;
import com.lee.ttest.mvp.presenter.BsbdjListPresenter;
import com.lee.ttest.mvp.presenter.BsbdjListPresenterImpl;
import com.lee.ttest.mvp.view.BsbdjDetailsView;
import com.lee.ttest.mvp.view.BsbdjListView;
import com.lee.ttest.widget.GifLoadingView;
import com.lee.ttest.widget.PullToRefreshLayout;
import com.lee.ttest.widget.PullableListView;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;

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
public class QsTjFragment extends BaseFragment implements BsbdjListView, BsbdjDetailsView, PullToRefreshLayout
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

    private String pageToken = "";
    private String commentPage = "1";
    private BsbdjListPresenter mPresenter;
    private int lastVisibleItemPosition = 0;// 标记上次滑动位置  
    private boolean scrollFlag = false;
    private boolean isFirstIn = true;
    private List<BsbdjListBean.DataBean> mDataBeen;
    private BsbdjApapter mBsbdjApapter;
    private boolean pressedHome;
    private HomeKeyWatcher mHomeKeyWatcher;
    private BsbdjDetailsPresenter mDetailsPresenter;
    private String ID = "";
    
    public static QsTjFragment getInstence(int type) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        QsTjFragment fragment = new QsTjFragment();
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

        mBsbdjApapter = new BsbdjApapter(getActivity());
        mList.setAdapter(mBsbdjApapter);

        initVideo();

        BsbdjListBean bean = new BsbdjListBean();
        bean = (BsbdjListBean) MyApplication.ACACHE.getAsObject("BsbdjListBean");
        if (bean != null && bean.getData().size() > 0){
            mBsbdjApapter.setDataBeen(bean.getData());
        }

        mDataBeen = new ArrayList<>();
        refreshView.autoRefresh();
        mPresenter = new BsbdjListPresenterImpl(this);
        mDetailsPresenter = new BsbdjDetailsPresenterImpl(this);
    }

    @Override
    protected void initDatas() {
        mBsbdjApapter.setOnItemTextViewClickListener(new BsbdjApapter.onItemTextViewListener() {
            @Override
            public void onTextViewClick(int position, View view) {
                switch (view.getId()){
                    case R.id.imageview:
                        if (mDataBeen.get(position).getImageUrls().size() > 0) {
                            List<String> imgUrls = mDataBeen.get(position).getImageUrls();
                            Intent intent = new Intent(getActivity(), BsbdjImageActivity.class);
                            intent.putExtra("imgUrl", imgUrls.get(imgUrls.size() - 1));
                            startActivity(intent);
                        }
                        break;
                    case R.id.share:
                        Intent intent1 = new Intent(Intent.ACTION_SEND);
                        intent1.setType("text/plain");
                        intent1.putExtra(Intent.EXTRA_TEXT, mDataBeen.get(position).getUrl());
                        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(Intent.createChooser(intent1, "分享该链接"));
                        break;
                }
            }
        });
    }
    private void initVideo() {
        mHomeKeyWatcher = new HomeKeyWatcher(getActivity());
        mHomeKeyWatcher.setOnHomePressedListener(new HomeKeyWatcher.OnHomePressedListener() {
            @Override
            public void onHomePressed() {
                pressedHome = true;
            }
        });
        pressedHome = false;
        mHomeKeyWatcher.startWatch();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
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
    public  void onStop() {
        // 在OnStop中是release还是suspend播放器，需要看是不是因为按了Home键
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
        super.onStop();
        mHomeKeyWatcher.stopWatch();
    }

    private boolean SAVE = true;
    
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showDatas(BsbdjDetailsBean bean) {
        
    }

    @Override
    public void showPopuFaied() {

    }

    @Override
    public void showDatas(BsbdjListBean bean) {
        refreshView.refreshFinish(PullToRefreshLayout.SUCCEED);

        for (int i = 0; i < bean.getData().size(); i++) {
            if ("".equals(bean.getData().get(i).getContent())) {
                bean.getData().remove(i);
            }
            if ("爆笑Gif".equals(bean.getData().get(i).getCatName1())){
                bean.getData().remove(i);
            }
        }

        mDataBeen.addAll(bean.getData());

        if (mDataBeen.size() == 0) {
            noDatas.setVisibility(View.VISIBLE);
            refreshView.setVisibility(View.GONE);
            return;
        } else {
            noDatas.setVisibility(View.GONE);
            refreshView.setVisibility(View.VISIBLE);
        }
        pageToken = bean.getPageToken();

        mBsbdjApapter.setDataBeen(mDataBeen);

        if (SAVE){
            MyApplication.ACACHE.remove("BsbdjListBean");
            MyApplication.ACACHE.put("BsbdjListBean", bean);
            SAVE = false;
        }
    }

    @Override
    public void showFaied() {
        noDatas.setVisibility(View.VISIBLE);
        refreshView.setVisibility(View.GONE);
        refreshView.refreshFinish(PullToRefreshLayout.SUCCEED);
    }

    @Override
    public void onRefresh(final PullToRefreshLayout pullToRefreshLayout) {
        pageToken = "";
        mPresenter.setDatas(getActivity(), pageToken);
    }

    @Override
    public void onLoadMore(final PullToRefreshLayout pullToRefreshLayout) {
        if ("null".equals(pageToken)){
            Toast.makeText(getActivity(), "暂时没有更多了哦~~~", Toast.LENGTH_SHORT).show();
            try {
                refreshView.refreshFinish(PullToRefreshLayout.SUCCEED);
            } catch (Exception e){
                e.printStackTrace();
            }
            return;
        }
        mPresenter.setDatas(getActivity(), pageToken);
    }
}
//jhfghfh