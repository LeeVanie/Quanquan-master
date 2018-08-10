package com.lee.ttest.activity.set;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lee.ttest.R;
import com.lee.ttest.application.MyApplication;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.bean.Setting;
import com.lee.ttest.widget.GestureLockViewGroup;

import butterknife.BindView;

/**
 * 取消手势密码
 */
public class LockOffActivity extends BaseActivity {
    private static final String TAG = LockOffActivity.class.getSimpleName();
    @BindView(R.id.tv_prompt_lock_off)
    TextView mTextView;
    @BindView(R.id.gesture_lock_view_group_lock_off)
    GestureLockViewGroup mGesture;
    @BindView(R.id.activity_unlock)
    LinearLayout activityUnlock;

    private Context mContext;
    private MyApplication myApp;

    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void initInjecter() {
        setTitle("取消手势密码");
        mContext = this;

        myApp = MyApplication.getApplication();

        initView();
    }

    @Override
    protected int getresLayoutID() {
        return R.layout.activity_lock_off;
    }

    private void initView() {
        mTextView.setText("请绘制手势密码");

        mGesture.setAnswer(myApp.getSettings().getGesture());
        mGesture.setShowPath(Setting.SHOW_PATH.equals(myApp.getSettings().getShowPath()));
        mGesture.setOnGestureLockViewListener(mListener);
    }

    private void gestureEvent(boolean matched) {
        if (matched) {
            mTextView.setText("输入正确，手势关闭");
            MyApplication.getApplication().setSettings(new Setting("", Setting.SHOW_PATH));
            setResult(RESULT_OK);
            finish();
        } else {
            mTextView.setText("手势错误，还剩" + mGesture.getTryTimes() + "次");
        }
    }

    private void unmatchedExceedBoundary() {
        // 正常情况这里需要做处理（如退出或重登）
        Toast.makeText(mContext, "错误次数太多，请重新登录", Toast.LENGTH_SHORT).show();
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
            unmatchedExceedBoundary();
        }

        @Override
        public void onFirstSetPattern(boolean patternOk) {
        }
    };
}
