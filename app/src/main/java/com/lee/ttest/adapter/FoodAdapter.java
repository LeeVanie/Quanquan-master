package com.lee.ttest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lee.ttest.R;
import com.lee.ttest.bean.FoodTitleBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
public class FoodAdapter extends BaseAdapter {
    List<FoodTitleBean> items;
    Context context;

    public FoodAdapter(Context context) {
        this.context = context;
        this.items = new ArrayList<>();
    }

    public void setItems(List<FoodTitleBean> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FoodTitleAdapter.ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.food_text_item, parent, false);
            holder = new FoodTitleAdapter.ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (FoodTitleAdapter.ViewHolder) convertView.getTag();
        }

        holder.textview.setText(items.get(position).getTitle());
        holder.textview.setTextSize(17);
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.textview)
        TextView textview;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}

//jhfghfh