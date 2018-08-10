package com.lee.ttest.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


import com.lee.ttest.utils.IntentUtils;
import com.lee.ttest.utils.LocationAddress;

import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;

/**
 * @类名: ${type_name}
 * @功能描述:   位置经纬度信息和极光推送设备ID
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class LocationService extends Service {

    public static String registrationId;

    @Override
    public void onCreate() {

        LocationAddress.getInstence().initAddress(getApplicationContext());

        super.onCreate();
    }

    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       
        if (intent == null) {
            stopSelf();
            return Service.START_NOT_STICKY;
        }
        final boolean isExit = intent.getBooleanExtra("exit", false);
        if (isExit) {
            stopSelf();
        }
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                LocationAddress.getInstence().initLocation();
            }
        };
        timer.schedule(timerTask, 0, 10*60*1000);
        return Service.START_NOT_STICKY;

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

   
    /**
     * <br/> 方法名称:startService
     * <br/> 方法详述:启动时间服务
     * <br/> 参数:
     * <br/>&nbsp;&nbsp;&nbsp;&nbsp;mContext:上下文依赖
     * <br/>&nbsp;&nbsp;&nbsp;&nbsp;isExit:
     * <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;true:停止当前服务
     * <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;false:启动当前服务
     */
    public static void startService(Context mContext, boolean isExit) {
        Intent gpsIntent = new Intent();
        gpsIntent.setAction("com.lee.ttest.service.LocationService");
        gpsIntent.putExtra("exit", isExit);
        //        gpsIntent.setPackage(mContext.getPackageName());
        Intent eintent = new Intent(IntentUtils.getExplicitIntent(mContext, gpsIntent));
        mContext.startService(eintent);
        Log.e("Location", "bindGPSService");
    }
    
    
}
//jhfghfh