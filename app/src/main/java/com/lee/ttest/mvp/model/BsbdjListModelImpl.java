package com.lee.ttest.mvp.model;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.lee.ttest.bean.BsbdjListBean;
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
public class BsbdjListModelImpl implements BsbdjListModel {

    @Override
    public void loadDatas(Context context, String pageToken, final Callback callback) {
            if (!"".equals(pageToken)) {
                OkHttpUtils.get().url(Apis.URL_BSBDJ)
                        .addParams("pageToken", pageToken)
                        .addParams("catid", "1")
                        .addParams("apikey", Apis.URL_BSBDJ_KEY)
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Call call, Exception e, int id) {
                                callback.loadFailed();
                            }
                            @Override
                            public void onResponse(String response, int id) {
                                try {
                                    BsbdjListBean bean = JSONObject.parseObject(response, BsbdjListBean.class);
                                    if (bean.getData().size() > 0) {
                                        callback.loadSuccess(bean);
                                    } else {
                                        callback.loadFailed();
                                    }
                                } catch (Exception e){
                                    callback.loadFailed();
                                }
                            }
                        });
            } else {
                OkHttpUtils.get().url("http://120.76.205.241:8000/post/baisibudejie")
                        .addParams("catid", "1")
                        .addParams("apikey", "pYDa49vZeXvFVDK1IPwp5P1fs7FOkRZimCzyVZEhT9j53d6CJAtFY6LPNRvfe6pb")
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Call call, Exception e, int id) {
                                callback.loadFailed();
                            }
                            @Override
                            public void onResponse(String response, int id) {
                                try {
                                    BsbdjListBean bean = JSONObject.parseObject(response, BsbdjListBean.class);
                                    if (bean.getData().size() > 0) {
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
}
//jhfghfh