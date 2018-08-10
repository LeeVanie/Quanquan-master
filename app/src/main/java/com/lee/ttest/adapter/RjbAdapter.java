package com.lee.ttest.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lee.ttest.R;
import com.lee.ttest.activity.jsb.RjbAddActivity;
import com.lee.ttest.base.MyOnSlipStatusListener;
import com.lee.ttest.db.User;
import com.lee.ttest.widget.SwipeListLayout;

import java.util.List;

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
public class RjbAdapter extends BaseAdapter {

    private List<User> mUsers;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public RjbAdapter(List<User> users, Context context) {
        mUsers = users;
        mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mUsers != null ? mUsers.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mUsers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.rjb_list_child, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.time.setText(mUsers.get(position).getTime());
        holder.title.setText(mUsers.get(position).getTitle());

        if (null != mUsers.get(position).getColor() && !"".equals(mUsers.get(position).getColor())) {
            color = mUsers.get(position).getColor();
        } else {
            color = "#ffffffff";
        }
        holder.rjbAll.setBackgroundColor(Color.parseColor(color));

        holder.rjbAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, RjbAddActivity.class);
                intent.putExtra("TITLE", mUsers.get(position).getTitle());
                intent.putExtra("CONTENT", mUsers.get(position).getContent());
                if (null != mUsers.get(position).getColor() && !"".equals(mUsers.get(position).getColor())) {
                    color = mUsers.get(position).getColor();
                } else {
                    color = "#ffffffff";
                }
                intent.putExtra("COLOR", color);
                mContext.startActivity(intent);
            }
        });

//        final ViewHolder finalHolder = holder;
//        holder.tvDelete.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                finalHolder.sllMain.setStatus(SwipeListLayout.Status.Close, true);
//                mUsers.remove(position);
//                notifyDataSetChanged();
//            }
//        });
        
//        holder.sllMain.setOnSwipeStatusListener(new MyOnSlipStatusListener(holder.sllMain));
        
        return convertView;
    }

    private String color;

    static class ViewHolder {
        @BindView(R.id.tv_delete)
        TextView tvDelete;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.rjb_all)
        LinearLayout rjbAll;
        @BindView(R.id.sll_main)
        SwipeListLayout sllMain;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
//jhfghfh