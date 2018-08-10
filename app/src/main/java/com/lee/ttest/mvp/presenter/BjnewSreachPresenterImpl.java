package com.lee.ttest.mvp.presenter;

import android.content.Context;

import com.lee.ttest.bean.BjNewListBean;
import com.lee.ttest.bean.BjSreachBean;
import com.lee.ttest.mvp.model.BjnewModel;
import com.lee.ttest.mvp.model.BjnewModelImpl;
import com.lee.ttest.mvp.model.BjnewSreachModel;
import com.lee.ttest.mvp.model.BjnewSreachModelImpl;
import com.lee.ttest.mvp.view.BjnewListView;
import com.lee.ttest.mvp.view.BjnewSreachView;
import com.lee.ttest.utils.NetWorkUtils;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class BjnewSreachPresenterImpl implements BjnewSreachPresenter {

    BjnewSreachView mView;
    BjnewSreachModel mModel;
    
    
    public BjnewSreachPresenterImpl(BjnewSreachView view) {
        mView = view;
        this.mModel = new BjnewSreachModelImpl();
    }

    @Override
    public void setDatas(Context context, String id) {
        if (!NetWorkUtils.isNetworkConnected(context)){
            mView.showFailed();
            return;
        }

        mModel.loadDatas(context, id, new BjnewSreachModel.Callback() {
            @Override
            public void loadSuccess(BjSreachBean.ResultBeanX.ResultBean bean) {
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