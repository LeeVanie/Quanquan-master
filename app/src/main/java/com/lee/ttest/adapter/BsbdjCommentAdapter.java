package com.lee.ttest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lee.ttest.R;
import com.lee.ttest.bean.BsbdjDetailsBean;

import java.util.ArrayList;
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
public class BsbdjCommentAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private List<BsbdjDetailsBean.DataBean> mDataBeen;

    public BsbdjCommentAdapter(Context context) {
        mContext = context;
        mDataBeen = new ArrayList<>();
        mInflater = LayoutInflater.from(context);
    }

    public void setDataBeen(List<BsbdjDetailsBean.DataBean> dataBeen) {
        mDataBeen = dataBeen;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mDataBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.bsbdj_details_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        
        holder.name.setText(mDataBeen.get(position).getCommenterScreenName());
        holder.content.setText(mDataBeen.get(position).getContent());
        holder.date.setText(mDataBeen.get(position).getPublishDateStr().replace("T", " "));

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.content)
        TextView content;
        @BindView(R.id.date)
        TextView date;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
//jhfghfh