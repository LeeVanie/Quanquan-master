package com.lee.ttest.mvp.presenter;

import android.content.Context;

import com.lee.ttest.bean.WeatherBean;
import com.lee.ttest.mvp.model.MainFragmentModel;
import com.lee.ttest.mvp.model.MainFragmentModelImpl;
import com.lee.ttest.mvp.view.MainFragmentView;
import com.lee.ttest.utils.NetWorkUtils;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class MainFragmentPresenterImpl implements MainFragmentPresenter {


    MainFragmentView mView;
    MainFragmentModel mModel;

    public MainFragmentPresenterImpl(MainFragmentView view) {
        mView = view;
        this.mModel = new MainFragmentModelImpl();
    }
    
    
    @Override
    public void setDatas(Context context, String location) {
        if (!NetWorkUtils.isNetworkConnected(context)){
            mView.showFailed();
            return;
        }

        mModel.LoadDatas(context, location, new MainFragmentModel.Callback() {
            @Override
            public void loadSuccess(WeatherBean.HeWeather6Bean.NowBean bean) {
                mView.showWeather(bean);
            }

            @Override
            public void loadFailed() {
                mView.showFailed();
            }
        });
    }
}
