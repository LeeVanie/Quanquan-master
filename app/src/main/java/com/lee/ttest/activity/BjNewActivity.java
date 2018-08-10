package com.lee.ttest.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.lee.ttest.R;
import com.lee.ttest.adapter.BjnewFragmentAdapter;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.bean.BjTypeBean;
import com.lee.ttest.mvp.presenter.BjTypePresenter;
import com.lee.ttest.mvp.presenter.BjTypePresenterImpl;
import com.lee.ttest.mvp.view.BjTypeView;
import com.lee.ttest.utils.ToastUtils;

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
public class BjNewActivity extends BaseActivity implements BjTypeView {
    @BindView(R.id.back)
    TextView back;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.sreach_btn)
    TextView sreach_btn;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.main)
    LinearLayout main;
    
    private BjnewFragmentAdapter mBjnewFragmentAdapter;
    
    @Override
    protected void initEventAndData() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        sreach_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopuPicture();
            }
        });
    }

    @Override
    protected void initInjecter() {
        title.setText("百家播报");
        BjTypePresenter presenter = new BjTypePresenterImpl(this);
        presenter.setDatas(this);
    }

    @Override
    protected int getresLayoutID() {
        return R.layout.bjnew;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void showDatas(BjTypeBean.ResultBean bean) {
        if (bean.getResult().size() > 0) {
            mBjnewFragmentAdapter = new BjnewFragmentAdapter(this.getSupportFragmentManager(), bean);
            viewpager.setAdapter(mBjnewFragmentAdapter);
            tabLayout.setupWithViewPager(viewpager);
        }
    }

    @Override
    public void showFailed() {
        ToastUtils.showToast(this, "网络错误");
    }


    /**
     * 显示图片弹窗
     */
    PopupWindow window = null;

    private void showPopuPicture() {

        View popupView = this.getLayoutInflater().inflate(R.layout.bj_sreach, null);
        final EditText edit_content = (EditText) popupView.findViewById(R.id.edit_content);
        ImageView sreach = (ImageView) popupView.findViewById(R.id.sreach);
        TextView clear = (TextView) popupView.findViewById(R.id.clear);
        ListView listview = (ListView) popupView.findViewById(R.id.listview);
        window = new PopupWindow(popupView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new BitmapDrawable());
        window.setFocusable(true);
        window.setOutsideTouchable(true);
        window.update();
        window.showAtLocation(main, Gravity.CENTER, 0, 0);
        window.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // 如果点击了popupwindow的外部，popupwindow也会消失
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
                if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                    window.dismiss();
                    return true;
                }
                return false;
            }
        });
        window.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

            }
        });
        sreach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = edit_content.getText().toString().trim();
                if (!"".equals(content)){
                    Intent intent = new Intent(BjNewActivity.this, BjSreachActivity.class);
                    intent.putExtra("KEY", content);
                    startActivity(intent);
                }
            }
        });

    }
}
//jhfghfh