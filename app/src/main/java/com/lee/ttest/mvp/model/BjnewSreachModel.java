package com.lee.ttest.mvp.model;

import android.content.Context;

import com.lee.ttest.bean.BjNewListBean;
import com.lee.ttest.bean.BjSreachBean;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public interface BjnewSreachModel {
    
    void loadDatas(Context context, String id, Callback callback);

    interface Callback{
        void loadSuccess(BjSreachBean.ResultBeanX.ResultBean beanList);
        void loadFailed();
    }
}
//jhfghfh