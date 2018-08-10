package com.lee.ttest.activity.food;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.lee.ttest.R;
import com.lee.ttest.base.BaseActivity;

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
public class FoodWebViewActivity extends BaseActivity {
    @BindView(R.id.webview)
    WebView webView;
    @BindView(R.id.back)
    TextView back;
    @BindView(R.id.title)
    TextView title;
    private String url;

    @Override
    protected void initEventAndData() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    @Override
    protected void initInjecter() {
        url = getIntent().getStringExtra("url");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setUseWideViewPort(true);//设置webview推荐使用的窗口
        webSettings.setLoadWithOverviewMode(true);//设置webview加载的页面的模式
        webSettings.setJavaScriptEnabled(true);// 设置支持javascript脚本
        webSettings.setSupportZoom(true);// 支持缩放
        webSettings.setBuiltInZoomControls(true);// 设置显示缩放按钮
        webSettings.setDisplayZoomControls(false);//隐藏webview缩放按钮
        webSettings.setAllowFileAccess(true); // 允许访问文件
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);

        webSettings.setPluginState(WebSettings.PluginState.ON);
        //主要用于平板，针对特定屏幕代码调整分辨率
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int mDensity = metrics.densityDpi;
        if (mDensity == 240) {
            webSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        } else if (mDensity == 160) {
            webSettings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        } else if (mDensity == 120) {
            webSettings.setDefaultZoom(WebSettings.ZoomDensity.CLOSE);
        } else if (mDensity == DisplayMetrics.DENSITY_XHIGH) {
            webSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        } else if (mDensity == DisplayMetrics.DENSITY_TV) {
            webSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        } else {
            webSettings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        }

        /**
         * 用WebView显示图片，可使用这个参数 设置网页布局类型：
         * 1、LayoutAlgorithm.NARROW_COLUMNS ：适应内容大小
         * 2、LayoutAlgorithm.SINGLE_COLUMN:适应屏幕，内容将自动缩放
         */
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);

        
        
        webView.loadUrl(url);

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);

                return true;
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            //作用：获得网页的加载进度并显示
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
            }

            //作用：获取Web页中的标题
            // 每个网页的页面都有一个标题，比如www.baidu.com这个页面的标题即“百度一下，你就知道”
            @Override
            public void onReceivedTitle(WebView view, String titleStr) {
                title.setText(titleStr);
            }
        });
    }

    @Override
    protected int getresLayoutID() {
        return R.layout.food_author;
    }

    @Override
    public void onBackPressed() {
//        if ( webView.canGoBack()) {
//            webView.goBack();// 返回HTML前一个页面
//            return;
//        }
        finish();
    }

    
    
}
//jhfghfh