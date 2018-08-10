package com.lee.ttest.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lee.ttest.R;
import com.lee.ttest.adapter.BsbdjApapter;
import com.lee.ttest.adapter.BsbdjCommentAdapter;
import com.lee.ttest.application.MyApplication;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.base.HomeKeyWatcher;
import com.lee.ttest.bean.BsbdjDetailsBean;
import com.lee.ttest.bean.BsbdjListBean;
import com.lee.ttest.common.ACache;
import com.lee.ttest.mvp.presenter.BsbdjDetailsPresenter;
import com.lee.ttest.mvp.presenter.BsbdjDetailsPresenterImpl;
import com.lee.ttest.mvp.presenter.BsbdjListPresenter;
import com.lee.ttest.mvp.presenter.BsbdjListPresenterImpl;
import com.lee.ttest.mvp.view.BsbdjDetailsView;
import com.lee.ttest.mvp.view.BsbdjListView;
import com.lee.ttest.widget.GifLoadingView;
import com.lee.ttest.widget.PullToRefreshLayout;
import com.lee.ttest.widget.PullableListView;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;

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
public class BsbdjListActivity extends BaseActivity implements BsbdjListView, BsbdjDetailsView, PullToRefreshLayout
        .OnRefreshListener {
    @BindView(R.id.back)
    TextView back;
    @BindView(R.id.title)
    TextView title;
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
    private GifLoadingView gifLoadingView;
    private String ID = "";
    private BsbdjApapter.LoadData mLoadData;
    
    @Override
    protected void initEventAndData() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mBsbdjApapter.setOnItemTextViewClickListener(new BsbdjApapter.onItemTextViewListener() {
            @Override
            public void onTextViewClick(int position, View view) {
                switch (view.getId()){
                    case R.id.comment:
                        ID = mDataBeen.get(position).getId();
                        showPopu(view);
                        gifLoadingView.show();
                        commentPage = "1";
                        mDetailsPresenter.setDatas(BsbdjListActivity.this, ID, commentPage);
                        break;
                    case R.id.imageview:
                        if (mDataBeen.get(position).getImageUrls().size() > 0) {
                            List<String> imgUrls = mDataBeen.get(position).getImageUrls();
                            Intent intent = new Intent(BsbdjListActivity.this, BsbdjImageActivity.class);
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

    @Override
    protected void initInjecter() {
        title.setText("轻松一刻");
        refreshView.setOnRefreshListener(this);
        noDatas.setVisibility(View.GONE);
        refreshView.setVisibility(View.VISIBLE);
        initFab();

        gifLoadingView = new GifLoadingView((ViewGroup) refreshView.getRootView(), this, "正在为您加载....");
        gifLoadingView.setCanceledOnTouchOutside(true);

        mBsbdjApapter = new BsbdjApapter(this);
        mList.setAdapter(mBsbdjApapter);
        
        mLoadData = mBsbdjApapter.new LoadData();
        
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

    private void initVideo() {
        mHomeKeyWatcher = new HomeKeyWatcher(this);
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
    protected int getresLayoutID() {
        return R.layout.bsbdj;
    }

    @Override
    protected void onStop() {
        // 在OnStop中是release还是suspend播放器，需要看是不是因为按了Home键
        if (pressedHome) {
            NiceVideoPlayerManager.instance().suspendNiceVideoPlayer();
        } else {
            NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
        }

        //判断当前的异步任务是否为空，并且判断当前的异步任务的状态是否是运行状态{RUNNING(运行),PENDING(准备),FINISHED(完成)}  
        if (mLoadData != null && mLoadData.getStatus() == AsyncTask.Status.RUNNING) {
            /**
             *cancel(true) 取消当前的异步任务，传入的true,表示当中断异步任务时继续已经运行的线程的操作， 
             *但是为了线程的安全一般为让它继续设为true 
             * */
            mLoadData.cancel(true);

        }
        super.onStop();
        mHomeKeyWatcher.stopWatch();
    }

    @Override
    protected void onRestart() {
        mHomeKeyWatcher.startWatch();
        pressedHome = false;
        super.onRestart();
        NiceVideoPlayerManager.instance().resumeNiceVideoPlayer();
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
    
    private boolean SAVE = true;
    
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
    public void onBackPressed() {
        if (NiceVideoPlayerManager.instance().onBackPressd()) {
            return;
        }
        super.onBackPressed();
        finish();
    }

    @Override
    public void onRefresh(final PullToRefreshLayout pullToRefreshLayout) {
        pageToken = "";
        mPresenter.setDatas(BsbdjListActivity.this, pageToken);
    }

    @Override
    public void onLoadMore(final PullToRefreshLayout pullToRefreshLayout) {
        if ("null".equals(pageToken)){
            Toast.makeText(this, "暂时没有更多了哦~~~", Toast.LENGTH_SHORT).show();
            try {
                refreshView.refreshFinish(PullToRefreshLayout.SUCCEED);
            } catch (Exception e){
                e.printStackTrace();
            }
            return;
        }
        mPresenter.setDatas(BsbdjListActivity.this, pageToken);
    }


    @Override
    public void showDatas(BsbdjDetailsBean bean) {
        try {
            gifLoadingView.dismiss();
            holder.refreshView.refreshFinish(PullToRefreshLayout.SUCCEED);
            if (bean.getData().size() != 0) {
                holder.noDatas.setVisibility(View.GONE);
                holder.listview.setVisibility(View.VISIBLE);
            } else {
                holder.noDatas.setVisibility(View.VISIBLE);
                holder.listview.setVisibility(View.GONE);
                return;
            }

            commentPage = bean.getPageToken() + "";

            mDataBeanList.addAll(bean.getData());
            mCommentAdapter.setDataBeen(mDataBeanList);
        } catch (Exception e){
            
        }
    }

    @Override
    public void showPopuFaied() {
        try{
            gifLoadingView.dismiss();
            holder.refreshView.refreshFinish(PullToRefreshLayout.SUCCEED);
            holder.noDatas.setVisibility(View.VISIBLE);
            holder.listview.setVisibility(View.GONE);
        } catch (Exception e){
            
        }
    }

    private List<BsbdjDetailsBean.DataBean> mDataBeanList;
    private BsbdjCommentAdapter mCommentAdapter;
    private ViewHolder holder = null;

    public void showPopu(View view) {

        mDataBeanList = new ArrayList<>();
        View contentView = LayoutInflater.from(this).inflate(R.layout.popu_bsbdj_comment, null);

        final PopupWindow popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup
                .LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
                return false;
            }
        });
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.white));

        holder = new ViewHolder(contentView);
        mCommentAdapter = new BsbdjCommentAdapter(this);
        holder.listview.setAdapter(mCommentAdapter);

        if (!popupWindow.isShowing()) {
            popupWindow.showAsDropDown(view, 0, 10);
        }
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

            }
        });

        holder.refreshView.setOnRefreshListener(new PullToRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
                return;
            }

            @Override
            public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
                if ("null".equals(commentPage)){
                    Toast.makeText(BsbdjListActivity.this, "暂时没有更多了哦~~~", Toast.LENGTH_SHORT).show();
                    try {
                        refreshView.refreshFinish(PullToRefreshLayout.SUCCEED);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    return;
                }
                mDetailsPresenter.setDatas(BsbdjListActivity.this, ID, commentPage);
            }
        });

    }

    static class ViewHolder {
        @BindView(R.id.content_view)
        PullableListView listview;
        @BindView(R.id.refresh_view)
        PullToRefreshLayout refreshView;
        @BindView(R.id.no_datas)
        LinearLayout noDatas;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
    
}
//jhfghfh