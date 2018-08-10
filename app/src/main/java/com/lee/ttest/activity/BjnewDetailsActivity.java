package com.lee.ttest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lee.ttest.R;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.bean.BjNewListBean;

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
public class BjnewDetailsActivity extends BaseActivity {
    @BindView(R.id.back)
    TextView back;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.details_title)
    TextView detailsTitle;
    @BindView(R.id.type)
    TextView type;
    @BindView(R.id.author)
    TextView author;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.images)
    LinearLayout images;
    @BindView(R.id.content)
    TextView content;
    @BindView(R.id.weburl)
    TextView weburl;
    @BindView(R.id.scrollView)
    ScrollView scrollView;

    private BjNewListBean.ResultBeanX.ResultBean.ListBean mDataBean;
    
    @Override
    protected void initEventAndData() {
        scrollView.scrollTo(0, 0);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
//        weburl.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent inten = new Intent(BjnewDetailsActivity.this, WebViewActivity.class);
//                inten.putExtra("url", mDataBean.getUrl());
//                startActivity(inten);
//            }
//        });
    }

    @Override
    protected void initInjecter() {
        Intent intent = this.getIntent();
        mDataBean = (BjNewListBean.ResultBeanX.ResultBean.ListBean) intent.getSerializableExtra("BjNewListBean");

        title.setText("详情");
        detailsTitle.setText(mDataBean.getTitle());
        author.setText(mDataBean.getSrc());
        date.setText(mDataBean.getTime());
        content.setText("\t\t" + mDataBean.getContent());
        weburl.setText(Html.fromHtml("<a href=#>点击阅读原文</a>"));
        weburl.setVisibility(View.GONE);
        final List<String> imgUrls = new ArrayList<>();
        imgUrls.add(mDataBean.getPic());
        LayoutInflater inflater = LayoutInflater.from(this);
        for (int i = 0; i < imgUrls.size(); i++) {
            final String url = imgUrls.get(i);
            View view = inflater.inflate(R.layout.bjnew_image, images, false);
            ImageView picture = (ImageView) view.findViewById(R.id.imageview);
            Glide.with(this).load(url).into(picture);
            picture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(BjnewDetailsActivity.this, BsbdjImageActivity.class);
                    intent.putExtra("imgUrl", url);
                    startActivity(intent);
                }
            });
            images.addView(view);
        }
    }

    @Override
    protected int getresLayoutID() {
        return R.layout.bjnew_details;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
//jhfghfh