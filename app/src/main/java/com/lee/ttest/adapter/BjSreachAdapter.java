package com.lee.ttest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lee.ttest.R;
import com.lee.ttest.bean.BjSreachBean;

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
public class BjSreachAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;

    public void setListBeans(List<BjSreachBean.ResultBeanX.ResultBean.ListBean> listBeans) {
        mListBeans = listBeans;
    }

    private List<BjSreachBean.ResultBeanX.ResultBean.ListBean> mListBeans;
    public static final int TYPE_NORMAL = 1;
    private static final int TYPE_FOOTER = 2;

    public BjSreachAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getItemViewType(int position) {

        if (position + 1 == getItemCount() && mSwitch == 1) {
            return TYPE_FOOTER;
        }
        return TYPE_NORMAL;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_FOOTER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foot, parent, false);
            return new FooterViewHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bjnew_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ViewHolder viewHolder = (ViewHolder) holder;
            final BjSreachBean.ResultBeanX.ResultBean.ListBean bean = mListBeans.get(position);

            viewHolder.style01.setVisibility(View.GONE);
            viewHolder.style02.setVisibility(View.VISIBLE);
            viewHolder.imageview.setImageURI(bean.getPic());
            viewHolder.title02.setText(bean.getTitle());
            viewHolder.author02.setText(bean.getSrc());
            viewHolder.time02.setText(bean.getTime());

        }
    }

    class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }


    private int mSwitch = 0;

    @Override
    public int getItemCount() {
        return mListBeans == null ? 0 : mListBeans.size() + mSwitch;
    }

    public void setFooterOn() {
        mSwitch = 1;
        notifyDataSetChanged();
    }

    public void setFooterOff() {
        mSwitch = 0;
        notifyDataSetChanged();
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void OnItemClick(View view, int position, BjSreachBean.ResultBeanX.ResultBean.ListBean bean);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.title_01)
        TextView title01;
        @BindView(R.id.imageview01)
        SimpleDraweeView imageview01;
        @BindView(R.id.imageview02)
        SimpleDraweeView imageview02;
        @BindView(R.id.imageview03)
        SimpleDraweeView imageview03;
        @BindView(R.id.author)
        TextView author;
        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.style_01)
        LinearLayout style01;
        @BindView(R.id.title_02)
        TextView title02;
        @BindView(R.id.author_02)
        TextView author02;
        @BindView(R.id.time_02)
        TextView time02;
        @BindView(R.id.imageview)
        SimpleDraweeView imageview;
        @BindView(R.id.style_02)
        LinearLayout style02;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
