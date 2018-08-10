package com.lee.ttest.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.lee.ttest.R;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by mfp on 15-12-22.
 */
public class BrowserActivity extends Activity {

    private WebView mWebView;
    private TextView next;
    private String url;
    private AlphaAnimation mShowAnimation= null;
    private boolean isFirst = true;
    private Handler handler=null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        handler = new Handler();
        mWebView = (WebView) findViewById(R.id.webview);
        next = (TextView) findViewById(R.id.next);
        initweb();
        url = "file:///android_asset/qixi/index.html";
        mWebView.loadUrl(url);
        next.setVisibility(View.GONE);
        
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFirst = false;
                Intent inten = new Intent(BrowserActivity.this, WebViewActivity.class);
                inten.putExtra("url", "file:///android_asset/love/index.html");
                startActivity(inten);
                finish();
            }
        });
    }

    private void initweb() {
        mWebView.getSettings().setDefaultTextEncodingName("UTF-8");
        mWebView.setWebViewClient(new InnerWebViewClient());
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setAppCacheEnabled(true);
        mWebView.getSettings().setDatabaseEnabled(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            mWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }

        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    private class InnerWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            if (isFirst) {
                new Thread(){
                    public void run(){
                        try {
                            Thread.sleep(30000);
                            handler.post(runnableUi);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        }
    }
    // 构建Runnable对象，在runnable中更新界面  
    Runnable   runnableUi=new  Runnable(){
        @Override
        public void run() {
            //更新界面  
            next.setVisibility(View.VISIBLE);
            setShowAnimation(next, 3000);
        }

    };
    
    private void setShowAnimation( View view, int duration ){

        if( null == view || duration < 0 ){
            return;
        }
        if( null != mShowAnimation ){

            mShowAnimation.cancel( );
        }
        mShowAnimation = new AlphaAnimation(0.0f, 1.0f);
        mShowAnimation.setDuration(duration);
        mShowAnimation.setFillAfter(true);
        view.startAnimation(mShowAnimation);

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            mWebView.onPause();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            mWebView.onResume();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWebView.resumeTimers();
        mWebView.destroy();
    }
}
