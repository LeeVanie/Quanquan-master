package com.lee.ttest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lee.ttest.R;
import com.lee.ttest.bean.BjNewListBean;

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
public class BjnewListAdapter extends BaseAdapter {

    private List<BjNewListBean.ResultBeanX.ResultBean.ListBean> mDataBeen;
    private Context mContext;
    private LayoutInflater mInflater;

    public BjnewListAdapter(Context context) {
        mContext = context;
        this.mDataBeen = new ArrayList<>();
        mInflater = LayoutInflater.from(mContext);
    }

    public void setDataBeen(List<BjNewListBean.ResultBeanX.ResultBean.ListBean> dataBeen) {
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
            convertView = mInflater.inflate(R.layout.bjnew_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.style01.setVisibility(View.GONE);
        holder.style02.setVisibility(View.VISIBLE);
        holder.imageview.setImageURI(mDataBeen.get(position).getPic());
        holder.title02.setText(mDataBeen.get(position).getTitle());
        holder.author02.setText(mDataBeen.get(position).getSrc());
        holder.time02.setText(mDataBeen.get(position).getTime());

//        String string = mDataBeen.get(position).getPublishDateStr();
//        List<String> imgUrls = mDataBeen.get(position).getImageUrls();
//        if (imgUrls.size() == 1){
//            holder.style01.setVisibility(View.GONE);
//            holder.style02.setVisibility(View.VISIBLE);
//            holder.imageview.setImageURI(imgUrls.get(0));
//            holder.title02.setText(mDataBeen.get(position).getTitle()); 
//            holder.author02.setText(mDataBeen.get(position).getPosterScreenName());
//            holder.time02.setText(string.substring(0, string.indexOf("T")));
//        } else {
//            holder.style01.setVisibility(View.VISIBLE);
//            holder.style02.setVisibility(View.GONE);
//            holder.title01.setText(mDataBeen.get(position).getTitle());
//            holder.imageview01.setImageURI(imgUrls.get(0));
//            holder.imageview02.setImageURI(imgUrls.get(1));
//            holder.imageview03.setImageURI(imgUrls.get(2));
//            holder.author.setText(mDataBeen.get(position).getPosterScreenName());
//            holder.time.setText(string.substring(0, string.indexOf("T")));
//        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.title_01)
        TextView title01;
        @BindView(R.id.style_01)
        LinearLayout style01;
        @BindView(R.id.title_02)
        TextView title02;
        @BindView(R.id.imageview)
        SimpleDraweeView imageview;
        @BindView(R.id.imageview01)
        SimpleDraweeView imageview01;
        @BindView(R.id.imageview02)
        SimpleDraweeView imageview02;
        @BindView(R.id.imageview03)
        SimpleDraweeView imageview03;
        @BindView(R.id.style_02)
        LinearLayout style02;
        @BindView(R.id.author)
        TextView author;
        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.author_02)
        TextView author02;
        @BindView(R.id.time_02)
        TextView time02;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
//jhfghfh