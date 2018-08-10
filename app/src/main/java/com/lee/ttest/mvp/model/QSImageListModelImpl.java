package com.lee.ttest.mvp.model;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.lee.ttest.bean.QSImageBean;
import com.lee.ttest.bean.QSTextBean;
import com.lee.ttest.common.Apis;
import com.lee.ttest.utils.Date_U;
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
public class QSImageListModelImpl implements QSImageModel {

    @Override
    public void loadDatas(Context context, String type, String pageToken, final Callback callback) {
            if (!"".equals(pageToken)) {
                OkHttpUtils.get().url(Apis.URL_QSIMAGE + type)
                        .addParams("maxResult", "20")
                        .addParams("page", pageToken)
                        .addParams("showapi_appid", "56808")
                        .addParams("showapi_test_draft", "false")
                        .addParams("showapi_timestamp", Date_U.getCurrentTime3().substring(0, 14))
                        .addParams("showapi_sign", Apis.URL_QSIMAGE_KEY)
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Call call, Exception e, int id) {
                                callback.loadFailed();
                            }
                            @Override
                            public void onResponse(String response, int id) {
                                try {
                                    QSImageBean bean = JSONObject.parseObject(response, QSImageBean.class);
                                    if (bean.getShowapi_res_body() != null) {
                                        if (bean.getShowapi_res_body().getContentlist().size() > 0) {
                                            callback.loadSuccess(bean);
                                        } else {
                                            callback.loadFailed();
                                        }
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