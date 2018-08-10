package com.lee.ttest.activity;

import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.ImageViewState;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lee.ttest.R;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.widget.LongImageView;

import java.io.File;

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
public class BsbdjImageActivity extends BaseActivity {
    @BindView(R.id.imageview)
    SubsamplingScaleImageView imageview;
    
    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void initInjecter() {
        String imgUrl = getIntent().getStringExtra("imgUrl");
        imageview.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CUSTOM);
        imageview.setMinScale(1.0F);
        Glide.with(this).load(imgUrl).downloadOnly(new SimpleTarget<File>() {
            @Override
            public void onResourceReady(File resource, GlideAnimation<? super File> glideAnimation) {
                // 将保存的图片地址给SubsamplingScaleImageView,这里注意设置ImageViewState设置初始显示比例   
                imageview.setImage(ImageSource.uri(Uri.fromFile(resource)), new ImageViewState(1.0F, new PointF(0, 0)
                        , 0));
            }});
        
    }

    @Override
    protected int getresLayoutID() {
        return R.layout.bsbdj_image;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
//jhfghfh