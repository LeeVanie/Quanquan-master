package com.lee.ttest.mvp.view;

import com.lee.ttest.bean.WeatherBean;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public interface MainFragmentView {
    
    void showWeather(WeatherBean.HeWeather6Bean.NowBean bean);
    
    void showFailed();
    
}
