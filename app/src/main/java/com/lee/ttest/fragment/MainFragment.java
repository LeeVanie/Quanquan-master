package com.lee.ttest.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.lee.ttest.R;
import com.lee.ttest.activity.ArticalActivity;
import com.lee.ttest.activity.BjNewActivity;
import com.lee.ttest.activity.QsylActivity;
import com.lee.ttest.activity.bill.BillMain;
import com.lee.ttest.activity.food.FoodActivity;
import com.lee.ttest.activity.jsb.RjbActivity;
import com.lee.ttest.activity.lssdjt.HistoryActivity;
import com.lee.ttest.adapter.MainAdapter;
import com.lee.ttest.base.BaseFragment;
import com.lee.ttest.bean.WeatherBean;
import com.lee.ttest.common.Common;
import com.lee.ttest.mvp.presenter.MainFragmentPresenter;
import com.lee.ttest.mvp.presenter.MainFragmentPresenterImpl;
import com.lee.ttest.mvp.view.MainFragmentView;
import com.lee.ttest.utils.LocationAddress;
import com.lee.ttest.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class MainFragment extends BaseFragment implements MainFragmentView {
    @BindView(R.id.gridview)
    GridView gridview;
    Unbinder unbinder;
    @BindView(R.id.wendu)
    TextView wendu;
    @BindView(R.id.tianqi)
    ImageView tianqi;
    @BindView(R.id.fengli)
    TextView fengli;
    @BindView(R.id.tianqidesc)
    TextView tianqidesc;

    private String[] name = new String[]{"记事本", "账单", "今天", "美食", "轻松一刻", "百家新闻", "美文"};
    private int[] imgs = new int[]{R.mipmap.personal_book_type_decorate_th, R.mipmap.invite_logo, R.mipmap.lssdjt, R
            .mipmap.mstx, R.mipmap.bsbdj, R.mipmap.bjnew, R.mipmap.article};
    private MainAdapter mMainAdapter;

    @Override
    protected int getContentViewResID() {
        return R.layout.main_fragment;
    }

    @Override
    protected void initViews() {
        MainFragmentPresenter presenter = new MainFragmentPresenterImpl(this);
        presenter.setDatas(getActivity(), LocationAddress.getInstence().getAddress()[2].substring(0, 6) + "," +
                LocationAddress.getInstence().getAddress()[1].substring(0, 6));
    }

    @Override
    protected void initDatas() {
        mMainAdapter = new MainAdapter(getActivity(), name, imgs);
        gridview.setAdapter(mMainAdapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        getActivity().startActivity(new Intent(getActivity(), RjbActivity.class));
                        break;
                    case 1:
                        getActivity().startActivity(new Intent(getActivity(), BillMain.class));
                        break;
                    case 2:
                        getActivity().startActivity(new Intent(getActivity(), HistoryActivity.class));
                        break;
                    case 3:
                        getActivity().startActivity(new Intent(getActivity(), FoodActivity.class));
                        break;
                    case 4:
                        getActivity().startActivity(new Intent(getActivity(), QsylActivity.class));
                        break;
                    case 5:
                        getActivity().startActivity(new Intent(getActivity(), BjNewActivity.class));
                        break;
                    case 6:
                        getActivity().startActivity(new Intent(getActivity(), ArticalActivity.class));
                        break;
                }
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showWeather(WeatherBean.HeWeather6Bean.NowBean bean) {
        wendu.setText(bean.getTmp() + "℃");
        fengli.setText(bean.getWind_dir() + " 风力：" + bean.getWind_sc());
        tianqidesc.setText(bean.getCond_txt());
        tianqi.setImageDrawable(getResources().getDrawable(Common.getInstense().getWeatherPIC().get(bean.getCond_code())));
    }

    @Override
    public void showFailed() {
        ToastUtils.showToast(getActivity(), "未获取到当前天气信息");
        wendu.setText("--");
        fengli.setText("--");
        tianqidesc.setText("--");
        tianqi.setImageDrawable(getResources().getDrawable(R.drawable.w100));
    }
}
//jhfghfh