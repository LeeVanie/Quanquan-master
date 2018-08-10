package com.lee.ttest.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lee.ttest.R;
import com.lee.ttest.bean.BsbdjListBean;
import com.lee.ttest.utils.SLTUtils;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.TxVideoPlayerController;

import java.io.ByteArrayOutputStream;
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
public class BsbdjApapter extends BaseAdapter {

    private List<BsbdjListBean.DataBean> mDataBeen;
    private Context mContext;
    private LayoutInflater mInflater;
    public TxVideoPlayerController mController;
    private View convertView;
    
    public BsbdjApapter(Context context) {
        mContext = context;
        mDataBeen = new ArrayList<>();
        mInflater = LayoutInflater.from(context);
    }

    public void setDataBeen(List<BsbdjListBean.DataBean> dataBeen) {
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
            convertView = mInflater.inflate(R.layout.bsbdj_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        this.convertView = convertView;
        holder.title.setText(mDataBeen.get(position).getContent());
        List<String> tags = mDataBeen.get(position).getTags();
        if (tags != null && tags.size() > 0){
            holder.tag.setText(tags.get(0));
        }
        final ViewHolder finalHolder = holder;
        List<String> imgUrls = mDataBeen.get(position).getImageUrls();
        if (imgUrls != null && imgUrls.size() > 0) {
            holder.imageview.setVisibility(View.VISIBLE);
            Glide.with(convertView.getContext())
                    .load(imgUrls.get(imgUrls.size() - 1))
                    .placeholder(R.drawable.loading_placeholder)
                    .crossFade()
                    .into(holder.imageview);
            holder.imageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemDeleteListener.onTextViewClick(position, finalHolder.imageview);
                }
            });
        } else {
            holder.imageview.setVisibility(View.GONE);
        }
        holder.time.setText(mDataBeen.get(position).getPublishDateStr().replace("T", " "));
        holder.like.setText("点赞：" + mDataBeen.get(position).getLikeCount());
        holder.comment.setText("评论：" + mDataBeen.get(position).getCommentCount());
        holder.comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemDeleteListener.onTextViewClick(position, finalHolder.comment);
            }
        });
        holder.share.setText("转发：" + mDataBeen.get(position).getShareCount());
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemDeleteListener.onTextViewClick(position, finalHolder.share);
            }
        });
        try {
            List<String> videoUrl = mDataBeen.get(position).getVideoUrls();
            if (videoUrl != null && videoUrl.size() > 0){
                holder.LinearVideo.setVisibility(View.VISIBLE);
                mController = new TxVideoPlayerController(mContext);
                holder.videoview.setController(mController);
                mController.setTitle(mDataBeen.get(position).getTitle());
                holder.videoview.setUp(videoUrl.get(videoUrl.size() - 1), null);
                Glide.with(convertView.getContext())
                        .load(R.drawable.img_default)
                        .placeholder(R.drawable.img_default)
                        .crossFade().into(mController.imageView());

//                new LoadData().execute(videoUrl.get(videoUrl.size() - 1), mController);     
            } else {
                holder.LinearVideo.setVisibility(View.GONE);
            }
        } catch (Exception e){
            
        }
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
    
    public class LoadData extends AsyncTask<Object, Void, Bitmap> {
        String url ;
        TxVideoPlayerController mController;
        @Override
        protected void onPreExecute() {
            
        }

        // 后台执行获取数据操作
        @Override
        protected Bitmap doInBackground(Object... params) {
            url = (String) params[0];
            mController = (TxVideoPlayerController) params[1];
            return SLTUtils.getVideoThumbnail(url, 100, 100, MediaStore.Video.Thumbnails.MINI_KIND);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            // 线程执行完毕 绑定数据
            super.onPostExecute(bitmap);
            try {
                if (mContext != null) {
                    if (bitmap != null) {
                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
                        byte[] bytes = bos.toByteArray();
                        Glide.with(convertView.getContext()).load(bytes).placeholder(R.drawable.img_default).crossFade().into(mController.imageView());

                    } else {
                        Glide.with(convertView.getContext()).load(R.drawable.img_default).placeholder(R.drawable.img_default).crossFade().into(mController.imageView());
                    }
                }
            } catch (Exception e){
                
            }
        }
    }
    public static class ViewHolder {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.imageview)
        ImageView imageview;
        @BindView(R.id.videoview)
        NiceVideoPlayer videoview;
        @BindView(R.id.tag)
        TextView tag;
        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.like)
        TextView like;
        @BindView(R.id.comment)
        TextView comment;
        @BindView(R.id.share)
        TextView share;
        @BindView(R.id.linear_video)
        LinearLayout LinearVideo;
        @BindView(R.id.main)
        LinearLayout main;


        ViewHolder(View view) {
            ButterKnife.bind(this, view);
            // 将列表中的每个视频设置为默认16:9的比例
            ViewGroup.LayoutParams params = videoview.getLayoutParams();
            params.width = view.getResources().getDisplayMetrics().widthPixels; // 宽度为屏幕宽度
            params.height = (int) (params.width * 9f / 16f);    // 高度为宽度的9/16
            videoview.setLayoutParams(params);
        }
    }
}
//jhfghfh