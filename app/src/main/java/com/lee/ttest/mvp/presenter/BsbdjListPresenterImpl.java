package com.lee.ttest.mvp.presenter;

import android.content.Context;

import com.lee.ttest.bean.BsbdjListBean;
import com.lee.ttest.bean.HistoryDetailsBean;
import com.lee.ttest.mvp.model.BsbdjListModel;
import com.lee.ttest.mvp.model.BsbdjListModelImpl;
import com.lee.ttest.mvp.model.HistoryDetailsModel;
import com.lee.ttest.mvp.model.HistoryDetailsModelImpl;
import com.lee.ttest.mvp.view.BsbdjListView;
import com.lee.ttest.mvp.view.HistoryDetailsView;
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
public class BsbdjListPresenterImpl implements BsbdjListPresenter {

    BsbdjListView mView;
    BsbdjListModel mModel;

    public BsbdjListPresenterImpl(BsbdjListView view) {
        mView = view;
        this.mModel = new BsbdjListModelImpl();
    }

    @Override
    public void setDatas(Context context, String pageToken) {
        if (!NetWorkUtils.isNetworkConnected(context)){
            mView.showFaied();
            return;
        }

        mModel.loadDatas(context, pageToken, new BsbdjListModel.Callback() {
            @Override
            public void loadSuccess(BsbdjListBean bean) {
                mView.showDatas(bean);
            }

            @Override
            public void loadFailed() {
                mView.showFaied();
            }
        });
    }
}
//jhfghfh