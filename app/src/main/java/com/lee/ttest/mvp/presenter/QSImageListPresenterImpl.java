package com.lee.ttest.mvp.presenter;

import android.content.Context;

import com.lee.ttest.bean.QSImageBean;
import com.lee.ttest.bean.QSTextBean;
import com.lee.ttest.mvp.model.QSImageListModelImpl;
import com.lee.ttest.mvp.model.QSImageModel;
import com.lee.ttest.mvp.model.QSTextListModelImpl;
import com.lee.ttest.mvp.model.QsTextModel;
import com.lee.ttest.mvp.view.QsImageView;
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
public class QSImageListPresenterImpl implements QSImageListPresenter {

    QsImageView mView;
    QSImageModel mModel;

    public QSImageListPresenterImpl(QsImageView view) {
        mView = view;
        this.mModel = new QSImageListModelImpl();
    }

    @Override
    public void setDatas(Context context, String type, String pageToken) {

        if (!NetWorkUtils.isNetworkConnected(context)){
            mView.showFailed();
            return;
        }

        mModel.loadDatas(context, type, pageToken, new QSImageModel.Callback() {
            @Override
            public void loadSuccess(QSImageBean bean) {
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