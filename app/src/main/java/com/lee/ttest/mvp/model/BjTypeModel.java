package com.lee.ttest.mvp.model;

import android.content.Context;

import com.lee.ttest.bean.BjNewListBean;
import com.lee.ttest.bean.BjTypeBean;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public interface BjTypeModel {
    
    void loadDatas(Context context, Callback callback);

    interface Callback{
        void loadSuccess(BjTypeBean.ResultBean beanList);
        void loadFailed();
    }
    
}
