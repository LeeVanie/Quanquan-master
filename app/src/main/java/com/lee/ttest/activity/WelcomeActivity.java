package com.lee.ttest.activity;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lee.ttest.R;
import com.lee.ttest.application.MyApplication;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.common.Common;
import com.lee.ttest.common.Config;
import com.lee.ttest.utils.CopyAssetsFile;
import com.lee.ttest.utils.SPUtil;
import com.zhy.m.permission.MPermissions;
import com.zhy.m.permission.PermissionDenied;
import com.zhy.m.permission.PermissionGrant;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class WelcomeActivity extends BaseActivity {

    WebView mWebView;
    private String url;


    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void initInjecter() {

        MPermissions.requestPermissions(WelcomeActivity.this, Common.ACCESS_COARSE_LOCATION,
                Manifest.permission.READ_PHONE_STATE, Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        CopyAssetsFile assetsFile = new CopyAssetsFile();

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);


        assetsFile.copyFilesFassets(this, "assets/WakeUp.bin", "voicetest/WakeUp.bin");
        
        mWebView = (WebView) findViewById(R.id.webview);
        initweb();
        url = "file:///android_asset/qiuqian/index.html";
        mWebView.loadUrl(url);
        
        // 启动页不开启手势
        disablePatternLock(true);
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 读取设置
                MyApplication.getApplication().setSettings(Config.getGestureSettings());
                if (isCancle) {
                    return;
                }
                if (isFirstRun()) {
                    gotoSetPara();
                } else {
                    gotoLogin();
                }
            }
        }.start();

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


        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }
        });
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
        }
    }

    @PermissionGrant(Common.ACCESS_COARSE_LOCATION)
    public void requestSdcardSuccess() {

    }

    @PermissionDenied(Common.ACCESS_COARSE_LOCATION)
    public void requestSdcardFailed() {
        finish();
    }


    private void gotoSetPara() {
        startActivity(new Intent(this, RegisterActivity.class));
        finish();
    }

    private void gotoLogin() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    /**
     * 判断应用是否是第一次运行
     * @return
     */
    private boolean isFirstRun(){
        boolean isFirst = (boolean) SPUtil.get(this,"version_first_run_guide",true);
        if(isFirst){
            SPUtil.put(this,"version_first_run_guide",false);
        }
        return isFirst;
    }
    private boolean isCancle;
    @Override
    protected void onDestroy() {
        super.onDestroy();
        isCancle = true;
    }
    @Override
    protected int getresLayoutID() {
        return R.layout.welcome_activity;
    }
}
//jhfghfh