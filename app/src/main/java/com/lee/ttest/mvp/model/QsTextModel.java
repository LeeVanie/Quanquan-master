package com.lee.ttest.mvp.model;

import android.content.Context;

import com.lee.ttest.bean.BsbdjListBean;
import com.lee.ttest.bean.QSTextBean;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public interface QsTextModel {
    
     void loadDatas(Context context, String pageToken, Callback callback);

    interface Callback{
        void loadSuccess(QSTextBean bean);
        void loadFailed();
    }

}
//jhfghfh