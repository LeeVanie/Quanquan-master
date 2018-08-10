package com.lee.ttest.mvp.view;

import com.lee.ttest.bean.QiquBean;

import java.util.List;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public interface QiquView {
    
    void showDatas(List<QiquBean.ItemsBean> beanList);
    
    void noDatas(String message);
}
