package com.lee.ttest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
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
public class BillNewAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private int[] imgs ;
    private int[] imgSelected;
    private String[] texts;
    private int selectorPosition;
    
    
    public BillNewAdapter(Context context, int[] imgs, int[] imgSelected, String[] texts) {
        mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.imgs = imgs;
        this.imgSelected = imgSelected;
        this.texts = texts;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int position) {
        return imgs[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.bill_new_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else{
            holder = (ViewHolder) convertView.getTag();
        }
        
        holder.image.setImageResource(imgs[position]);
        holder.name.setText(texts[position]);
        
        if (selectorPosition == position){
            holder.image.setImageResource(imgSelected[position]);
        } else {
            holder.image.setImageResource(imgs[position]);
        }
        
        return convertView;
    }


    public void changeState(int pos) {
        selectorPosition = pos;
    }
    

    static class ViewHolder {
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.item_all)
        LinearLayout itemAll;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
//jhfghfh