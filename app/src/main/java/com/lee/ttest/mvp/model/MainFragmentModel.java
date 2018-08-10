package com.lee.ttest.mvp.model;

import android.content.Context;

import com.lee.ttest.bean.HistoryBean;
import com.lee.ttest.bean.WeatherBean;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public interface MainFragmentModel {
    
    
    void LoadDatas(Context context, String location, Callback callback);


    interface Callback{
        void loadSuccess(WeatherBean.HeWeather6Bean.NowBean bean);
        void loadFailed();
    }
}
