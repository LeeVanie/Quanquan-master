package com.lee.ttest.application;

import android.app.Activity;
import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.lee.ttest.bean.Setting;
import com.lee.ttest.common.ACache;
import com.lee.ttest.common.Config;
import com.lee.ttest.service.LocationService;
import com.zhy.http.okhttp.OkHttpUtils;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class MyApplication extends MultiDexApplication {


    public static String TAG = "MyApplication";
    public static Context AppContext;
    private static MyApplication mMyApplication;
    public static boolean hasGotToken = false;
    public static ACache ACACHE;
    @Override
    public void onCreate() {
        super.onCreate();

        mMyApplication = this;
        ACACHE = ACache.get(mMyApplication);
        activityList = new ArrayList<>(); 
        Fresco.initialize(getApplicationContext());
        init();
        Config.init(mMyApplication);
        LocationService.startService(getApplicationContext(), false);
//        startService(new Intent(this, Service1.class));
//        startService(new Intent(this, Service2.class));

        LitePal.initialize(this);
    }
    
    public static MyApplication getApplication() {
        return mMyApplication;
    }
    /**
     * 初始化
     */
    private void init() {
        
        //进行okhttp初始化配置
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                //                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS).readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }


    public static Context getContext() {
        return AppContext;
    }
    public static void setContext(Context ctx) {
        AppContext = ctx;
    }

    @Override
    public void onTerminate() {

        super.onTerminate();
    }

    /** ----------------------- 一些公共的变量 ------------------------- */
    private long lockTime = 0; // 保存的是最近一次调用onPause()的系统时间
    private Setting settings;  // 手势设置

    /** ----------------------- 一些set/get方法 ------------------------- */
    public long getLockTime() {
        return lockTime;
    }

    public void setLockTime(long lockTime) {
        this.lockTime = lockTime;
    }

    public Setting getSettings() {
        return settings;
    }

    public void setSettings(Setting settings) {
        this.settings = settings;
    }


    private List<Activity> activityList;

    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public void finishActivity() {

        if (activityList.size() == 0) {
            activityList.clear();
        }

        for (Activity activity : activityList) {
            activity.finish();
        }

    }
    
}
//jhfghfh