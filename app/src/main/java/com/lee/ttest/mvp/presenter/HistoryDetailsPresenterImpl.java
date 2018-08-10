package com.lee.ttest.mvp.presenter;

import android.content.Context;

import com.lee.ttest.bean.HistoryBean;
import com.lee.ttest.bean.HistoryDetailsBean;
import com.lee.ttest.mvp.model.HistoryDetailsModel;
import com.lee.ttest.mvp.model.HistoryDetailsModelImpl;
import com.lee.ttest.mvp.model.HistoryModel;
import com.lee.ttest.mvp.model.HistoryModelImpl;
import com.lee.ttest.mvp.view.HistoryDetailsView;
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
public class HistoryDetailsPresenterImpl implements HistoryDetailsPresenter {
    
    HistoryDetailsView mView;
    HistoryDetailsModel mModel;

    public HistoryDetailsPresenterImpl(HistoryDetailsView view) {
        mView = view;
        this.mModel = new HistoryDetailsModelImpl();
    }

    @Override
    public void setDatas(Context context, String id) {

        if (!NetWorkUtils.isNetworkConnected(context)){
            mView.showFailed();
            return;
        }

        mModel.loadDatas(context, id, new HistoryDetailsModel.Callback() {
            @Override
            public void loadSuccess(HistoryDetailsBean bean) {
                mView.showDatas(bean);
            }

            @Override
            public void loadFailed() {
                mView.showFailed();
            }
        });
    }
}
//jhfghfh