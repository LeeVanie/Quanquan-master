package com.lee.ttest.activity.jsb;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.lee.ttest.R;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.bean.RjbBean;
import com.lee.ttest.db.GreenDaoUtils;
import com.lee.ttest.db.User;
import com.lee.ttest.db.UserDao;
import com.lee.ttest.utils.Date_U;
import com.lee.ttest.utils.ToastUtils;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class RjbAddActivity extends BaseActivity {

    public static final String TAG = "OCRActivity";
    
    @BindView(R.id.btn_cancle)
    TextView btnCancle;
    @BindView(R.id.btn_save)
    TextView btnSave;
    @BindView(R.id.title)
    EditText title;
    @BindView(R.id.content)
    EditText content;
    @BindView(R.id.bg_color)
    TextView bgColor;
    @BindView(R.id.all)
    LinearLayout all;
    @BindView(R.id.all_bg)
    LinearLayout allBg;

    private RjbBean bean;
    private String time;
    private UserDao mUserDao;
    private String TITLE;
    private String CONTENT;
    private RjbBgAdapter bgAdapter;
    private String COLOR_INTENT;
    
    @Override
    protected void initEventAndData() {
        bgAdapter = new RjbBgAdapter(this);
    }

    @Override
    protected void initInjecter() {

        
        // 语音配置对象初始化(如果只使用 语音识别 或 语音合成 时都得先初始化这个)
        initView();
        mUserDao = GreenDaoUtils.getSingleTon().getmDaoSession().getUserDao();
        TITLE = getIntent().getExtras().getString("TITLE");
        CONTENT = getIntent().getExtras().getString("CONTENT");
        COLOR = getIntent().getExtras().getString("COLOR");
        if (null != TITLE && null != CONTENT) {
            title.setText(TITLE);
            content.setText(CONTENT);
        }
        allBg.setBackgroundColor(Color.parseColor(COLOR));
    }

    @Override
    protected int getresLayoutID() {
        return R.layout.activity_rjb_edit;
    }


    @OnClick({R.id.back, R.id.btn_cancle, R.id.btn_save, R.id.bg_color})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.btn_cancle:
                finish();
                break;
            case R.id.btn_save:
                saveRjb();
                break;
            case R.id.bg_color:
                setPopuWindow(bgColor);
                break;
        }
    }

    private User mUser;

    private void saveRjb() {
        time = Date_U.getCurrentTime2();
        String tit = title.getText().toString().trim();
        String con = content.getText().toString().trim();
        if ("".equals(tit)) {
            ToastUtils.showToast(this, "还没写标题呢");
            return;
        }
        if ("".equals(COLOR)){
            COLOR = "#ffffffff";
        }
        if (TITLE.equals(tit)) {
            mUser = mUserDao.queryBuilder().where(UserDao.Properties.Title.eq(tit)).build().unique();
            if (mUser != null) {
                mUser.setContent(con);
                mUser.setColor(COLOR);
                mUser.setTime(time);
                mUserDao.update(mUser);
            }
        } else {
            mUser = new User(null, time, tit, con, COLOR, "TAG");
            mUserDao.insert(mUser);
        }
        finish();

    }

    private void initView() {

    }
    

    public void setPopuWindow(View view) {
        final View contentView = LayoutInflater.from(this).inflate(R.layout.rjb_bg_popu, null);
        PopupWindow popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup
                .LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.white));
        if (!popupWindow.isShowing()) {
            popupWindow.showAsDropDown(view);
        }
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

            }
        });
        ViewHolder holder = new ViewHolder(contentView);
        bgAdapter.setUsers(colors);
        holder.gridview.setAdapter(bgAdapter);

    }
    private String COLOR;
    private String[] colors = new String[]{"#FFDEAD", "#ffffffff", "#FFE4E1", "#FFC0CB", "#EEE8CD", "#C1FFC1", 
            "#CD8C95", "#AB82FF"};

    static class ViewHolder {
        @BindView(R.id.gridview)
        GridView gridview;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }


    class RjbBgAdapter extends BaseAdapter {

        private String[] mUsers;
        private Context mContext;
        private LayoutInflater mLayoutInflater;


        public void setUsers(String[] users) {
            mUsers = users;
        }

        public RjbBgAdapter(Context context) {
            mContext = context;

            this.mLayoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return mUsers != null ? mUsers.length : 0;
        }

        @Override
        public Object getItem(int position) {
            return mUsers[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = mLayoutInflater.inflate(R.layout.rjb_bg_child, parent, false);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.bg.setBackgroundColor(Color.parseColor(mUsers[position]));

            holder.bgAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    COLOR = mUsers[position];
                   allBg.setBackgroundColor(Color.parseColor(mUsers[position]));
                }
            });


            return convertView;
        }

        class ViewHolder {
            @BindView(R.id.bg)
            TextView bg;
            @BindView(R.id.bg_all)
            LinearLayout bgAll;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }
    
}
//jhfghfh