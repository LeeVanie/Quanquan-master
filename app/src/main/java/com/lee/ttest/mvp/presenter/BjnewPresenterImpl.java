package com.lee.ttest.mvp.presenter;

import android.content.Context;

import com.lee.ttest.bean.BjNewListBean;
import com.lee.ttest.bean.BsbdjDetailsBean;
import com.lee.ttest.mvp.model.BjnewModel;
import com.lee.ttest.mvp.model.BjnewModelImpl;
import com.lee.ttest.mvp.model.BsbdjDetailsModel;
import com.lee.ttest.mvp.model.BsbdjDetailsModelImpl;
import com.lee.ttest.mvp.view.BjnewListView;
import com.lee.ttest.mvp.view.BsbdjDetailsView;
import com.lee.ttest.utils.NetWorkUtils;
import com.lee.ttest.widget.GifLoadingView;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class BjnewPresenterImpl implements BjnewPresenter {

    BjnewListView mView;
    BjnewModel mModel;
    
    int page = 0;
    
    public BjnewPresenterImpl(BjnewListView view) {
        mView = view;
        this.mModel = new BjnewModelImpl();
    }

    @Override
    public void setDatas(Context context, String id, int pageToken) {
        if (!NetWorkUtils.isNetworkConnected(context)){
            mView.showFailed();
            return;
        }
        
        if (pageToken == 0){
            page = 0;
        }
        
        mModel.loadDatas(context, id, String.valueOf(page), new BjnewModel.Callback() {
            @Override
            public void loadSuccess(BjNewListBean.ResultBeanX.ResultBean bean) {
                mView.showDatas(bean);
            }

            @Override
            public void loadFailed() {
                page -- ;
                mView.showFailed();
            }
        });
        page ++ ;
    }
}
//jhfghfh