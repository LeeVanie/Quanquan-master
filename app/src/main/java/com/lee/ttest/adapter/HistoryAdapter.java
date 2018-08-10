package com.lee.ttest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lee.ttest.R;
import com.lee.ttest.bean.HistoryBean;

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
public class HistoryAdapter extends BaseAdapter {

    private List<HistoryBean.ResultBean> beanList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public void setBeanList(List<HistoryBean.ResultBean> beanList) {
        this.beanList = beanList;
//        notifyDataSetChanged();
    }

    public HistoryAdapter(Context context) {
        mContext = context;
        beanList = new ArrayList<>();
        mLayoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return beanList.size();
    }

    @Override
    public Object getItem(int position) {
        return beanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.lssdjt_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        
        holder.title.setText(beanList.get(position).getTitle());
        holder.content.setText(beanList.get(position).getDes());
        holder.date.setText(beanList.get(position).getYear() + "年"
                            + beanList.get(position).getMonth() + "月"
                            + beanList.get(position).getDay() + "日");
        holder.lunar.setText(beanList.get(position).getLunar());
        String imgUrl = beanList.get(position).getPic();
        if ("".equals(imgUrl)){
            holder.imageview.setVisibility(View.GONE);
        } else {
            holder.imageview.setImageURI(imgUrl);
        }
        
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.imageview)
        SimpleDraweeView imageview;
        @BindView(R.id.content)
        TextView content;
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.lunar)
        TextView lunar;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
//jhfghfh