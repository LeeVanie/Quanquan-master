package com.lee.ttest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lee.ttest.R;
import com.lee.ttest.bean.QSTextBean;
import com.xiao.nicevideoplayer.TxVideoPlayerController;

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
public class QSTextApapter extends BaseAdapter {

    private List<QSTextBean.ShowapiResBodyBean.ContentlistBean> mDataBeen;
    private Context mContext;
    private LayoutInflater mInflater;
    public TxVideoPlayerController mController;
    private View convertView;

    public QSTextApapter(Context context) {
        mContext = context;
        mDataBeen = new ArrayList<>();
        mInflater = LayoutInflater.from(context);
    }

    public void setDataBeen(List<QSTextBean.ShowapiResBodyBean.ContentlistBean> dataBeen) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.qs_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.title.setText(mDataBeen.get(position).getTitle());
        holder.imageview.setVisibility(View.GONE);
        holder.content.setText(mDataBeen.get(position).getText());
        holder.time.setText(mDataBeen.get(position).getCt());
        setAnimation(holder.main, position);
        return convertView;
    }

    private int lastPosition = -1;
    private void setAnimation(View view,int position){
        if(position > lastPosition){
            Animation animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.item_bottom_in);
            view.startAnimation(animation);
            lastPosition=position;
        }

    }
    public interface onItemTextViewListener {
        void onTextViewClick(int i, View textView);
    }

    private onItemTextViewListener mOnItemDeleteListener;

    public void setOnItemTextViewClickListener(onItemTextViewListener mOnItemDeleteListener) {
        this.mOnItemDeleteListener = mOnItemDeleteListener;
    }


    static class ViewHolder {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.content)
        TextView content;
        @BindView(R.id.imageview)
        ImageView imageview;
        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.main)
        LinearLayout main;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
//jhfghfh