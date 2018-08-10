package com.lee.ttest.activity.set;

import android.widget.TextView;

import com.lee.ttest.R;
import com.lee.ttest.application.MyApplication;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.bean.Setting;
import com.lee.ttest.widget.GestureLockViewGroup;

import butterknife.BindView;


/**
 * 设置手势密码
 */
public class LockOnActivity extends BaseActivity {
    private static final String TAG = LockOnActivity.class.getSimpleName();
    @BindView(R.id.tv_prompt_lock_on)
    TextView mTextView;
    @BindView(R.id.gesture_lock_view_group_lock_on)
    GestureLockViewGroup mGesture;

    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void initInjecter() {
        setTitle("设置手势密码");

        initView();
    }

    @Override
    protected int getresLayoutID() {
        return R.layout.activity_lock_on;
    }

    private void initView() {
        mTextView.setText("请绘制手势密码");

        mGesture.isFirstSet(true);
        mGesture.setUnMatchExceedBoundary(10000);
        mGesture.setOnGestureLockViewListener(mListener);
    }

    private void gestureEvent(boolean matched) {
        if (matched) {
            mTextView.setText("设置成功");
            Setting setting = new Setting(mGesture.getChooseStr(), Setting.SHOW_PATH);
            MyApplication.getApplication().setSettings(setting);
            setResult(RESULT_OK);
            finish();
        } else {
            mTextView.setText("手势不一致，请重试");
        }
    }

    private void firstSetPattern(boolean patternOk) {
        if (patternOk) {
            mTextView.setText("请再次输入以确认");
        } else {
            mTextView.setText("需要四个点以上");
        }
    }

    // 回调监听
    private GestureLockViewGroup.OnGestureLockViewListener mListener = new GestureLockViewGroup
            .OnGestureLockViewListener() {
        @Override
        public void onGestureEvent(boolean matched) {
            gestureEvent(matched);
        }

        @Override
        public void onUnmatchedExceedBoundary() {
        }

        @Override
        public void onFirstSetPattern(boolean patternOk) {
            firstSetPattern(patternOk);
        }
    };
}
