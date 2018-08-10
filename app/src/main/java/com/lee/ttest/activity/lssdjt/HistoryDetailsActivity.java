package com.lee.ttest.activity.lssdjt;

import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.ImageViewState;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lee.ttest.R;
import com.lee.ttest.application.MyApplication;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.bean.HistoryDetailsBean;
import com.lee.ttest.mvp.presenter.HistoryDetailsPresenter;
import com.lee.ttest.mvp.presenter.HistoryDetailsPresenterImpl;
import com.lee.ttest.mvp.view.HistoryDetailsView;
import com.lee.ttest.widget.GifLoadingView;

import java.io.File;
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
public class HistoryDetailsActivity extends BaseActivity implements HistoryDetailsView {
    @BindView(R.id.back)
    TextView back;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.history_title)
    TextView historyTitle;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.lunar)
    TextView lunar;
    @BindView(R.id.des)
    TextView des;
    @BindView(R.id.imageview)
    SubsamplingScaleImageView imageview;
    @BindView(R.id.details)
    TextView details;
    @BindView(R.id.main_content)
    LinearLayout mainContent;
    @BindView(R.id.scrollview)
    ScrollView scrollview;
    @BindView(R.id.no_datas)
    LinearLayout noDatas;

    private GifLoadingView gifLoadingView;
    private HistoryDetailsPresenter mPresenter;
    private String id;

    @Override
    protected void initEventAndData() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void initInjecter() {
        title.setText("时间详情");
        id = getIntent().getStringExtra("ID");
        imageview.setVisibility(View.GONE);

        gifLoadingView = new GifLoadingView((ViewGroup) findViewById(R.id.main_content).getRootView(), this, "正在为您加载....");
        gifLoadingView.setCanceledOnTouchOutside(true);
        gifLoadingView.show();
        mPresenter = new HistoryDetailsPresenterImpl(this);
        mPresenter.setDatas(HistoryDetailsActivity.this, id);
    }

    @Override
    protected int getresLayoutID() {
        return R.layout.history_details;
    }

    @Override
    public void showDatas(HistoryDetailsBean bean) {
        gifLoadingView.dismiss();
        scrollview.setVisibility(View.VISIBLE);
        noDatas.setVisibility(View.GONE);
        List<HistoryDetailsBean.ResultBean> beanList = bean.getResult();
        historyTitle.setText(beanList.get(0).getTitle());
        date.setText(beanList.get(0).getYear() + "年" + beanList.get(0).getMonth() + "月" + beanList.get(0).getDay() + 
                "日");
        lunar.setText(beanList.get(0).getLunar());
        String imgUrl = beanList.get(0).getPic();
        if (!"".equals(imgUrl)){
            imageview.setVisibility(View.VISIBLE);
            imageview.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CUSTOM);
            imageview.setMinScale(1.0F);
            Glide.with(this).load(imgUrl).downloadOnly(new SimpleTarget<File>() {
                @Override
                public void onResourceReady(File resource, GlideAnimation<? super File> glideAnimation) {
                    // 将保存的图片地址给SubsamplingScaleImageView,这里注意设置ImageViewState设置初始显示比例   
                    imageview.setImage(ImageSource.uri(Uri.fromFile(resource)), new ImageViewState(1.5F, new PointF
                            (0, 0)
                            , 0));
                }});
        }
        des.setText("\t\t" + beanList.get(0).getDes());
        details.setText("\t\t" + beanList.get(0).getContent());
    }

    @Override
    public void showFailed() {
        gifLoadingView.dismiss();
        gifLoadingView.dismiss();
        scrollview.setVisibility(View.GONE);
        noDatas.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
//jhfghfh