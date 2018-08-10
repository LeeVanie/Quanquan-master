package com.lee.ttest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lee.ttest.R;

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
public class BillDetailsAdapter extends BaseAdapter {

    private String[] datas;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private String flag;

    public BillDetailsAdapter(String datas, Context context, String flag) {
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.flag = flag;
        this.datas = datas.split("#");

    }

    @Override
    public int getCount() {
        return datas.length;
    }

    @Override
    public Object getItem(int position) {
        return datas[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.bill_details_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String[] bean = datas[position].split("@");
        if (bean.length > 1) {
            holder.title.setText(bean[1]);
            if (!"$$$$".equals(bean[2])) {
                holder.remark.setText(bean[2]);
            } else {
                holder.remark.setVisibility(View.GONE);
            }
            if ("SHOU".equals(flag)) {
                holder.money.setText("+" + bean[0]);
            } else if ("CHU".equals(flag)) {
                holder.money.setText("-" + bean[0]);
            }
            holder.noDatas.setVisibility(View.GONE);
            holder.haveDatas.setVisibility(View.VISIBLE);
        } else {
            holder.noDatas.setVisibility(View.VISIBLE);
            holder.haveDatas.setVisibility(View.GONE);
        }

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.money)
        TextView money;
        @BindView(R.id.remark)
        TextView remark;
        @BindView(R.id.have_datas)
        LinearLayout haveDatas;
        @BindView(R.id.no_datas)
        TextView noDatas;
        @BindView(R.id.bill_all)
        LinearLayout billAll;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
//jhfghfh