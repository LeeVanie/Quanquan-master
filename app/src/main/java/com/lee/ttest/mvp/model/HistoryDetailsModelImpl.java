package com.lee.ttest.mvp.model;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.lee.ttest.bean.HistoryBean;
import com.lee.ttest.bean.HistoryDetailsBean;
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
public class HistoryDetailsModelImpl implements HistoryDetailsModel {
    @Override
    public void loadDatas(Context context, String id, final Callback callback) {
            OkHttpUtils.get().url(Apis.URL_HISTORY)
                    .addParams("v", "1.0")
                    .addParams("id", id)
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

                                HistoryDetailsBean bean = JSONObject.parseObject(response, HistoryDetailsBean.class);
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