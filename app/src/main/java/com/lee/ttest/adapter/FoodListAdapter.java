package com.lee.ttest.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lee.ttest.R;
import com.lee.ttest.bean.FoodDetailsBean;

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
public class FoodListAdapter extends BaseAdapter {

    private Context mContext;
    private List<FoodDetailsBean> mFoodDetailsBeanList;
    private LayoutInflater mInflater;

    public FoodListAdapter(Context context) {
        mContext = context;
        mFoodDetailsBeanList = new ArrayList<>();
        mInflater = LayoutInflater.from(context);
    }

    public void setFoodDetailsBeanList(List<FoodDetailsBean> foodDetailsBeanList) {
        mFoodDetailsBeanList = foodDetailsBeanList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mFoodDetailsBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return mFoodDetailsBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.food_list_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        
        holder.title.setText(mFoodDetailsBeanList.get(position).getTitle());
//        holder.foodImage.setImageURI(mFoodDetailsBeanList.get(position).getTitle());
        Glide.with(convertView.getContext())
                .load(mFoodDetailsBeanList.get(position).getImg())
                .placeholder(R.drawable.loading_placeholder)
                .crossFade()
                .into(holder.foodImage);
        holder.author.setText(mFoodDetailsBeanList.get(position).getAuthor());
        holder.content.setText(mFoodDetailsBeanList.get(position).getContent());
        
        holder.author.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mContext, WebViewActivity.class);
//                intent.putExtra("url", mFoodDetailsBeanList.get(position).getAuthorUrl());
//                mContext.startActivity(intent);
            }
        });

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.food_image)
        ImageView foodImage;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.author)
        TextView author;
        @BindView(R.id.content)
        TextView content;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
//jhfghfh