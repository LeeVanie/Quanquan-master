package com.lee.ttest.mvp.model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.lee.ttest.bean.BjNewListBean;
import com.lee.ttest.bean.BjSreachBean;
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
public class BjnewSreachModelImpl implements BjnewSreachModel {
    @Override
    public void loadDatas(Context context, String id, final Callback callback) {
            OkHttpUtils.get().url(Apis.URL_Sreach)
                    .addParams("keyword", id)
                    .addParams("appkey", Apis.URL_BAIJIA_KEY)
                    .build()
                    .execute(new StringCallback() {

                        @Override
                        public void onError(Call call, Exception e, int id) {
                            callback.loadFailed();
                        }

                        @Override
                        public void onResponse(String response, int id) {
                            try {
                                BjSreachBean bean = JSONObject.parseObject(response, BjSreachBean.class);
                                if (bean.getResult().getResult().getList().size() > 0) {
                                    callback.loadSuccess(bean.getResult().getResult());
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
