package com.lee.ttest.mvp.model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.lee.ttest.bean.HistoryBean;
import com.lee.ttest.bean.QiquBean;
import com.lee.ttest.common.Apis;
import com.lee.ttest.utils.NetWorkUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class HistoryModelImpl implements HistoryModel {
    @Override
    public void loadDatas(Context context, String month, String day, final Callback callback) {
            OkHttpUtils.get().url(Apis.URL_HISTORY_2)
                    .addParams("v", "1.0")
                    .addParams("month", month)
                    .addParams("day", day)
                    .addParams("key", Apis.URL_HISTORY_KEY)
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {
                            callback.loadFailed();
                        }

                        @Override
                        public void onResponse(String response, int id) {
                            try {


                                HistoryBean bean = JSONObject.parseObject(response, HistoryBean.class);
                                if (bean.getError_code() == 0) {
                                    callback.loadSuccess(bean);
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
//jhfghfh