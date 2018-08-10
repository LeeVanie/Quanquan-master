package com.lee.ttest.mvp.presenter;

import android.content.Context;

import com.lee.ttest.bean.BjNewListBean;
import com.lee.ttest.bean.BjTypeBean;
import com.lee.ttest.mvp.model.BjTypeModel;
import com.lee.ttest.mvp.model.BjTypeModelImpl;
import com.lee.ttest.mvp.model.BjnewModel;
import com.lee.ttest.mvp.model.BjnewModelImpl;
import com.lee.ttest.mvp.view.BjTypeView;
import com.lee.ttest.mvp.view.BjnewListView;
import com.lee.ttest.utils.NetWorkUtils;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class BjTypePresenterImpl implements BjTypePresenter {

    BjTypeView mView;
    BjTypeModel mModel;
    
    public BjTypePresenterImpl(BjTypeView view) {
        mView = view;
        this.mModel = new BjTypeModelImpl();
    }

    @Override
    public void setDatas(Context context) {
        if (!NetWorkUtils.isNetworkConnected(context)){
            mView.showFailed();
            return;
        }

        mModel.loadDatas(context, new BjTypeModel.Callback() {
            @Override
            public void loadSuccess(BjTypeBean.ResultBean beanList) {
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