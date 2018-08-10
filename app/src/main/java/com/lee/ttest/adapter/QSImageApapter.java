package com.lee.ttest.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.lee.ttest.R;
import com.lee.ttest.bean.QSImageBean;
import com.lee.ttest.bean.QSTextBean;
import com.xiao.nicevideoplayer.TxVideoPlayerController;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.droidsonroids.gif.GifImageView;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class QSImageApapter extends BaseAdapter {

    private List<QSImageBean.ShowapiResBodyBean.ContentlistBean> mDataBeen;
    private Context mContext;
    private LayoutInflater mInflater;
    public TxVideoPlayerController mController;
    private String flag;

    public QSImageApapter(Context context, String flag) {
        mContext = context;
        mDataBeen = new ArrayList<>();
        this.flag = flag;
        mInflater = LayoutInflater.from(context);
    }

    public void setDataBeen(List<QSImageBean.ShowapiResBodyBean.ContentlistBean> dataBeen) {
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
        holder.content.setVisibility(View.GONE);
        if ("2".equals(flag)) {
            holder.imageview.setVisibility(View.VISIBLE);
            holder.gif_image.setVisibility(View.GONE);
            Glide.with(convertView.getContext())
                    .load(mDataBeen.get(position).getImg())
                    .centerCrop()
                    .placeholder(R.drawable.loading_placeholder)
                    .crossFade()
                    .into(holder.imageview);
            
        } else if ("3".equals(flag)){
            holder.imageview.setVisibility(View.GONE);
            holder.gif_image.setVisibility(View.VISIBLE);
            Glide.with(convertView.getContext())
                    .load(mDataBeen.get(position).getImg())
                    .centerCrop()    
                    /*  
                     * 缺省的占位图片，一般可以设置成一个加载中的进度GIF图  
                     */
                    .placeholder(R.drawable.loading).crossFade().into(holder.gif_image);
        }
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
        @BindView(R.id.gif_image)
        GifImageView gif_image;
        @BindView(R.id.main)
        LinearLayout main;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
//jhfghfh