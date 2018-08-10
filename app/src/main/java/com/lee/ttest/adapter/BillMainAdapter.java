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
import com.lee.ttest.activity.bill.BillDetails;
import com.lee.ttest.db.BillBean;

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
public class BillMainAdapter extends BaseAdapter {

    private List<BillBean> mBeanList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private double total = 0;
    
    public BillMainAdapter(List<BillBean> users, Context context) {
        mBeanList = users;
        mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mBeanList != null ? mBeanList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.bill_main_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        
        holder.data.setText(mBeanList.get(position).getDatas());
        float shou = 0, chu = 0;
        if (!"".equals(mBeanList.get(position).getBillShouContent()) && null != mBeanList.get(position).getBillShouContent()) {

            String[] shous = mBeanList.get(position).getBillShouContent().split("#");
            for (int i = 0; i < shous.length; i++) {
                String[] s = shous[i].split("@");
                if (s.length > 1){
                    shou += Float.valueOf(s[0]).floatValue();
                }
            }
            
        }
        if (!"".equals(mBeanList.get(position).getBillChuContent()) && null != mBeanList.get(position).getBillChuContent()) {

            String[] shous = mBeanList.get(position).getBillChuContent().split("#");
            for (int i = 0; i < shous.length; i++) {
                String[] s = shous[i].split("@");
                if (s.length > 2){
                    chu += Float.valueOf(s[0]).floatValue();
                }
            }
        }
        
        total = shou - chu;
        
        if (total >= 0){
            holder.money.setBackgroundResource(R.drawable.bill_01);
            holder.money.setText("总计：+" + total);
        } else {
            holder.money.setBackgroundResource(R.drawable.bill_02);
            holder.money.setText("总计：" + total);
        }

        holder.linearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, BillDetails.class);
                intent.putExtra("DATA", mBeanList.get(position).getDatas());
                intent.putExtra("TYPE", mBeanList.get(position).getBillType());
                intent.putExtra("SHOUCONTENT", mBeanList.get(position).getBillShouContent());
                intent.putExtra("CHUCONTENT", mBeanList.get(position).getBillChuContent());
                mContext.startActivity(intent);
            }
        });

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.data)
        TextView data;
        @BindView(R.id.money)
        TextView money;
        @BindView(R.id.linear_all)
        LinearLayout linearAll;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
//jhfghfh