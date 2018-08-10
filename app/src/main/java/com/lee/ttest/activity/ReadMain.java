package com.lee.ttest.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lee.ttest.R;
import com.lee.ttest.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class ReadMain extends BaseActivity {
    @BindView(R.id.book_list_top_panel)
    RelativeLayout bookListTopPanel;
    @BindView(R.id.book_list)
    RecyclerView bookList;
    @BindView(R.id.book_index_scrollview)
    NestedScrollView bookIndexScrollview;
    @BindView(R.id.show_menu_btn)
    ImageView showMenuBtn;
    @BindView(R.id.title_text_view)
    TextView titleTextView;
    @BindView(R.id.go_search_btn)
    ImageView goSearchBtn;
    @BindView(R.id.title_bar_layout)
    RelativeLayout titleBarLayout;
    @BindView(R.id.activity_main)
    CoordinatorLayout activityMain;
    
    private int normalTopPanelHeight = 0;
    private int totalChangeAlphaArea = 0;
    //titleBar的颜色0 表示默认白色，1表示灰色，2表示黑色
    private int titleBarColor = 0;
    

    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void initInjecter() {

    }

    @Override
    protected int getresLayoutID() {
        return R.layout.read_main;
    }

}
//jhfghfh