package com.lee.ttest.mvp.model;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.lee.ttest.bean.HistoryBean;
import com.lee.ttest.bean.WeatherBean;
import com.lee.ttest.common.Apis;
import com.lee.ttest.utils.NetWorkUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class MainFragmentModelImpl implements MainFragmentModel {

    @Override
    public void LoadDatas(Context context, String location, final Callback callback) {
            OkHttpUtils.get().url(Apis.URL_WEATHER_CODE)
                    .addParams("location", location)
                    .addParams("key", Apis.URL_KEY)
                    .addParams("lang", "cn")
                    .addParams("unit", "m")
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {
                            callback.loadFailed();
                        }

                        @Override
                        public void onResponse(String response, int id) {
                            try {
                                WeatherBean bean = JSONObject.parseObject(response, WeatherBean.class);
                                if (bean.getHeWeather6().get(0).getStatus().equals("ok")) {
                                    callback.loadSuccess(bean.getHeWeather6().get(0).getNow());
                                } else {
                                    callback.loadFailed();
                                }
                            } catch (Exception e){
                                callback.loadFailed();
                            }
                        }
                    });
    }
}
