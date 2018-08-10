package com.lee.ttest.mvp.presenter;

import android.content.Context;

import com.lee.ttest.bean.HistoryBean;
import com.lee.ttest.mvp.model.HistoryModel;
import com.lee.ttest.mvp.model.HistoryModelImpl;
import com.lee.ttest.mvp.view.HistoryView;
import com.lee.ttest.utils.NetWorkUtils;

import java.util.List;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class HistoryPresenterImpl implements HistoryPresenter {
    
    HistoryView mView;
    HistoryModel mModel;

    public HistoryPresenterImpl(HistoryView view) {
        mView = view;
        this.mModel = new HistoryModelImpl();
    }

    @Override
    public void setDatas(Context context, String month, String day) {

        if (!NetWorkUtils.isNetworkConnected(context)){
            mView.showFailed();
            return;
        }

        mModel.loadDatas(context, month, day, new HistoryModel.Callback() {
            @Override
            public void loadSuccess(HistoryBean beanList) {
                mView.showDatas(beanList);
            }

            @Override
            public void loadFailed() {
                mView.showFailed();
            }
        });
    }
}
//jhfghfh