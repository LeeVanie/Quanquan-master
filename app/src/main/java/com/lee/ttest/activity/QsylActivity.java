package com.lee.ttest.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.lee.ttest.R;
import com.lee.ttest.adapter.BjnewFragmentAdapter;
import com.lee.ttest.adapter.QSFragmentAdapter;
import com.lee.ttest.base.BaseActivity;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;

import butterknife.BindView;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class QsylActivity extends BaseActivity {
    @BindView(R.id.back)
    TextView back;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    
    private QSFragmentAdapter adapter;
    
    @Override
    protected void initEventAndData() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        
    }

    @Override
    protected void initInjecter() {
        title.setText("放松一下");
        adapter = new QSFragmentAdapter(this, this.getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewpager);
    }

    @Override
    protected int getresLayoutID() {
        return R.layout.bjnew;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // 在全屏或者小窗口时按返回键要先退出全屏或小窗口，
        // 所以在Activity中onBackPress要交给NiceVideoPlayer先处理。
        if (NiceVideoPlayerManager.instance().onBackPressd()) return;
        finish();
    }
}
//jhfghfh