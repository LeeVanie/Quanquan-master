package com.lee.ttest.activity.jsb;

import android.content.Intent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.lee.ttest.R;
import com.lee.ttest.adapter.RjbAdapter;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.db.GreenDaoUtils;
import com.lee.ttest.db.User;
import com.lee.ttest.db.UserDao;
import com.lee.ttest.widget.SwipeListLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class RjbActivity extends BaseActivity {
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ic_title)
    TextView icTitle;
    @BindView(R.id.more)
    TextView more;
    @BindView(R.id.number)
    TextView number;
    @BindView(R.id.list_view)
    ListView listView;
    @BindView(R.id.datas)
    LinearLayout datas;
    @BindView(R.id.no_datas)
    LinearLayout noDatas;

    private UserDao mUserDao;
    private List<User> mUsers;
    private RjbAdapter mRjbAdapter;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void initEventAndData() {
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    //当listview开始滑动时，若有item的状态为Open，则Close，然后移除
                    case SCROLL_STATE_TOUCH_SCROLL:
//                        if (sets.size() > 0) {
//                            for (SwipeListLayout s : sets) {
//                                s.setStatus(SwipeListLayout.Status.Close, true);
//                                sets.remove(s);
//                            }
//                        }
                        break;

                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
//        mUsers = mUserDao.loadAll();
        mUsers = mUserDao.queryBuilder().where(UserDao.Properties.Tag.eq("TAG")).orderDesc(UserDao.Properties.Time).list();
        
        if (mUsers.size() == 0) {
            datas.setVisibility(View.GONE);
            noDatas.setVisibility(View.VISIBLE);
            number.setText("0篇");
        } else {
            datas.setVisibility(View.VISIBLE);
            noDatas.setVisibility(View.GONE);
            number.setText(mUsers.size() + "篇");
            mRjbAdapter = new RjbAdapter(mUsers, this);
            listView.setAdapter(mRjbAdapter);
        }
        
    }

    @Override
    protected void initInjecter() {
        icTitle.setText("备忘录");
        
        mUserDao = GreenDaoUtils.getSingleTon().getmDaoSession().getUserDao();
        
    }

    @Override
    protected int getresLayoutID() {
        return R.layout.activity_rjb;
    }


    @OnClick({R.id.back, R.id.more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                onBackPressed();
                break;
            case R.id.more:
                Intent intent = new Intent(this, RjbAddActivity.class);
                intent.putExtra("TITLE", "");
                intent.putExtra("CONTENT", "");
                intent.putExtra("COLOR", "#ffffffff");
                startActivity(intent);
                break;
        }
    }
    
    
}
//jhfghfh