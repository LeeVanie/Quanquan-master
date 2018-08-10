package com.lee.ttest.activity.set;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.lee.ttest.R;
import com.lee.ttest.application.MyApplication;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.bean.Setting;
import com.lee.ttest.widget.GestureLockViewGroup;

import butterknife.BindView;


public class LockActivity extends BaseActivity {
    private static final String TAG = LockActivity.class.getSimpleName();
    @BindView(R.id.tv_prompt_lock)
    TextView tvPromptLock;
    @BindView(R.id.gesture_lock_view_group_lock)
    GestureLockViewGroup gestureLockViewGroupLock;

    private Context mContext;
    private MyApplication myApp;

    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void initInjecter() {
        setTitle("手势密码");
        mContext = this;
        myApp = MyApplication.getApplication();
        // 禁止唤起手势页
        disablePatternLock(false);

        initView();
    }

    @Override
    protected int getresLayoutID() {
        return R.layout.activity_lock;
    }

    private void initView() {
        
        tvPromptLock.setText("请绘制手势密码");
        gestureLockViewGroupLock.setAnswer(myApp.getSettings().getGesture());
        gestureLockViewGroupLock.setShowPath(Setting.SHOW_PATH.equals(myApp.getSettings().getShowPath()));
        gestureLockViewGroupLock.setOnGestureLockViewListener(mListener);
    }

    @Override
    public void onBackPressed() {
        // 阻止Lock页面的返回事件
        moveTaskToBack(true);
    }

    /**
     * 处理手势图案的输入结果
     *
     * @param matched
     */
    private void gestureEvent(boolean matched) {
        if (matched) {
            tvPromptLock.setText("输入正确");
            finish();
        } else {
            tvPromptLock.setText("手势错误，还剩" + gestureLockViewGroupLock.getTryTimes() + "次");
        }
    }

    /**
     * 处理输错次数超限的情况
     */
    private void unmatchedExceedBoundary() {
        // 正常情况这里需要做处理（如退出或重登）
        Toast.makeText(mContext, "错误次数太多，请重新登录", Toast.LENGTH_SHORT).show();
    }

    // 手势操作的回调监听
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
