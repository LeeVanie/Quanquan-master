package com.lee.ttest.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lee.ttest.fragment.BjNewFragment;
import com.lee.ttest.fragment.QSGifFragment;
import com.lee.ttest.fragment.QSImageFragment;
import com.lee.ttest.fragment.QSTextFragment;
import com.lee.ttest.fragment.QsTjFragment;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class QSFragmentAdapter extends FragmentPagerAdapter {
    
    private static final int PAGE_COUNT = 4;
    private Context mContext;
    
    public QSFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.mContext = context;
    }
    
    int[] type = new int[]{1, 2, 3, 4};
    
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = QsTjFragment.getInstence(type[position]);
                break;
            case 1:
                fragment = QSTextFragment.getInstence(type[position]);
                break;
            case 2:
                fragment = QSImageFragment.getInstence(type[position]);
                break;
            case 3:
                fragment = QSGifFragment.getInstence(type[position]);
                break;
        }
        return fragment;
    }
    
    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
    
    private String[] titles = new String[]{"推荐", "笑话", "图片", "动图"};
    
    @Override
    public CharSequence getPageTitle(int position) {
       return titles[position];
    }
}
//jhfghfh