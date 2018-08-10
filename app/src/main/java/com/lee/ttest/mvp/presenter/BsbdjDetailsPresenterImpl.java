package com.lee.ttest.mvp.presenter;

import android.content.Context;

import com.lee.ttest.bean.BsbdjDetailsBean;
import com.lee.ttest.bean.BsbdjListBean;
import com.lee.ttest.mvp.model.BsbdjDetailsModel;
import com.lee.ttest.mvp.model.BsbdjDetailsModelImpl;
import com.lee.ttest.mvp.model.BsbdjListModel;
import com.lee.ttest.mvp.model.BsbdjListModelImpl;
import com.lee.ttest.mvp.view.BsbdjDetailsView;
import com.lee.ttest.mvp.view.BsbdjListView;
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
public class BsbdjDetailsPresenterImpl implements BsbdjDetailsPresenter {

    BsbdjDetailsView mView;
    BsbdjDetailsModel mModel;

    public BsbdjDetailsPresenterImpl(BsbdjDetailsView view) {
        mView = view;
        this.mModel = new BsbdjDetailsModelImpl();
    }

    @Override
    public void setDatas(Context context, String id, String pageToken) {
        if (!NetWorkUtils.isNetworkConnected(context)){
            mView.showPopuFaied();
            return;
        }

        mModel.loadDatas(context, id, pageToken, new BsbdjDetailsModel.Callback() {
            @Override
            public void loadSuccess(BsbdjDetailsBean bean) {
                mView.showDatas(bean);
            }

            @Override
            public void loadFailed() {
                mView.showPopuFaied();
            }
        });
    }
}
//jhfghfh