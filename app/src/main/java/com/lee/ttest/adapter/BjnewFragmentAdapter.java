package com.lee.ttest.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.lee.ttest.bean.BjTypeBean;
import com.lee.ttest.fragment.BjNewFragment;

import java.util.List;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class BjnewFragmentAdapter extends FragmentPagerAdapter {
    
    private List<String> mResultBeans;
    
    public BjnewFragmentAdapter(FragmentManager fm, BjTypeBean.ResultBean mResult) {
        super(fm);
        this.mResultBeans = mResult.getResult();
    }
    
    @Override
    public Fragment getItem(int position) {
        return BjNewFragment.getInstence(mResultBeans.get(position));
    }
    
    @Override
    public int getCount() {
        return mResultBeans.size();
    }
    
    @Override
    public CharSequence getPageTitle(int position) {
       return mResultBeans.get(position);
    }
}
//jhfghfh