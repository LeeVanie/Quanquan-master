package com.lee.ttest.mvp.view;

import android.support.v7.view.menu.ShowableListMenu;

import com.lee.ttest.bean.BjNewListBean;

import java.util.List;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public interface BjnewListView {
    
    void showDatas(BjNewListBean.ResultBeanX.ResultBean bean);
    
    void showFailed();
    
}
//jhfghfh