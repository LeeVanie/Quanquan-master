package com.lee.ttest.mvp.presenter;

import android.content.Context;

import com.lee.ttest.bean.BsbdjListBean;
import com.lee.ttest.bean.QSTextBean;
import com.lee.ttest.mvp.model.BsbdjListModel;
import com.lee.ttest.mvp.model.BsbdjListModelImpl;
import com.lee.ttest.mvp.model.QSTextListModelImpl;
import com.lee.ttest.mvp.model.QsTextModel;
import com.lee.ttest.mvp.view.BsbdjListView;
import com.lee.ttest.mvp.view.QsTextView;
import com.lee.ttest.utils.NetWorkUtils;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class QSTextListPresenterImpl implements QSTextListPresenter {

    QsTextView mView;
    QsTextModel mModel;

    public QSTextListPresenterImpl(QsTextView view) {
        mView = view;
        this.mModel = new QSTextListModelImpl();
    }

    @Override
    public void setDatas(Context context, String pageToken) {

        if (!NetWorkUtils.isNetworkConnected(context)){
            mView.showFailed();
            return;
        }

        mModel.loadDatas(context, pageToken, new QsTextModel.Callback() {
            @Override
            public void loadSuccess(QSTextBean bean) {
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