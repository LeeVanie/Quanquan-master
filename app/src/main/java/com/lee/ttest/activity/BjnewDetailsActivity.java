package com.lee.ttest.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lee.ttest.R;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.bean.BjNewListBean;
import com.lee.ttest.bean.BjSreachBean;

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
    @BindView(R.id.main_title)
    LinearLayout mainTitle;
    @BindView(R.id.webview)
    WebView webview;

    private BjNewListBean.ResultBeanX.ResultBean.ListBean mDataBean;
    private BjSreachBean.ResultBeanX.ResultBean.ListBean mDataBeanList;

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
        title.setText("详情");
        Intent intent = this.getIntent();
        String flag = getIntent().getStringExtra("FLAG");
        if (flag.equals("new")) {
            mDataBean = (BjNewListBean.ResultBeanX.ResultBean.ListBean) intent.getSerializableExtra("BjNewListBean");
            detailsTitle.setText(mDataBean.getTitle());
            author.setText(mDataBean.getSrc());
            date.setText(mDataBean.getTime());
            content.setText("\t\t" + mDataBean.getContent());
            webview.setVisibility(View.GONE);
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
        } else {
            mDataBeanList = (BjSreachBean.ResultBeanX.ResultBean.ListBean) intent.getSerializableExtra("BjNewListBean");
            detailsTitle.setText(mDataBeanList.getTitle());
            author.setText(mDataBeanList.getSrc());
            date.setText(mDataBeanList.getTime());
            content.setVisibility(View.GONE);
            
            webview.getSettings().setJavaScriptEnabled(true);
            webview.getSettings().setBuiltInZoomControls(true);
            webview.getSettings().setDisplayZoomControls(false);
            /*自适应屏幕*/
            webview.getSettings().setUseWideViewPort(true); //将图片调整到适合webview的大小
            webview.getSettings().setLoadWithOverviewMode(true); // 缩放至屏幕的大小
             /*细节操作*/
            webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true); //支持js弹窗
            webview.setWebChromeClient(new WebChromeClient());
            webview.setWebViewClient(new WebViewClient());
            webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY); //取消滚动条白边效果
            webview.getSettings().setDefaultTextEncodingName("UTF-8") ;
            webview.getSettings().setBlockNetworkImage(false);
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                webview.getSettings().setMixedContentMode(webview.getSettings()
                        .MIXED_CONTENT_ALWAYS_ALLOW);  //注意安卓5.0以上的权限
            }
            webview.loadDataWithBaseURL(null, mDataBeanList.getContent(), "text/html", "UTF-8", null);
            
            weburl.setText(Html.fromHtml("<a href=#>点击阅读原文</a>"));
            weburl.setVisibility(View.VISIBLE);
//            final List<String> imgUrls = new ArrayList<>();
//            imgUrls.add(mDataBeanList.getPic());
//            LayoutInflater inflater = LayoutInflater.from(this);
//            for (int i = 0; i < imgUrls.size(); i++) {
//                final String url = imgUrls.get(i);
//                View view = inflater.inflate(R.layout.bjnew_image, images, false);
//                ImageView picture = (ImageView) view.findViewById(R.id.imageview);
//                Glide.with(this).load(url).into(picture);
//                picture.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent(BjnewDetailsActivity.this, BsbdjImageActivity.class);
//                        intent.putExtra("imgUrl", url);
//                        startActivity(intent);
//                    }
//                });
//                images.addView(view);
//            }
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