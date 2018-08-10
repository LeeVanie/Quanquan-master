package com.lee.ttest.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lee.ttest.R;
import com.lee.ttest.bean.QiquBean;
import com.lee.ttest.bean.QiquBean;
import com.lee.ttest.refreshview.recyclerview.BaseRecyclerAdapter;
import com.lee.ttest.utils.ControllerListenerUtil;
import com.lee.ttest.utils.FrescoAttributeUtil;
import com.lee.ttest.utils.FrescoUtil;
import com.lee.ttest.utils.MyUtils;
import com.lee.ttest.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class QiquAdapter extends BaseRecyclerAdapter<QiquAdapter.QiquViewHolder> {

    private Context context;
    private List<QiquBean> mainItemBeanList;

    public QiquAdapter(Context context, List<QiquBean> mainItemBeanList) {
        this.context = context;
        this.mainItemBeanList = mainItemBeanList;
    }

    @Override
    public QiquViewHolder getViewHolder(View view) {
        return new QiquViewHolder(view);
    }

    @Override
    public QiquViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_main_layout, parent, false);
        return new QiquViewHolder(view);
    }

    @Override
    public void onBindViewHolder(QiquViewHolder holder, int position, boolean isItem) {
        QiquViewHolder mainViewHolder = holder;
        
    }

    @Override
    public int getAdapterItemCount() {
        return mainItemBeanList.size();
    }

    class QiquViewHolder extends RecyclerView.ViewHolder {

        TextView tvMainItem;
        SimpleDraweeView sdvMainItem;
        SimpleDraweeView sdvUserImg;
        TextView tvUserName;
        LinearLayout layoutUser;

        public QiquViewHolder(View itemView) {
            super(itemView);
            tvMainItem = (TextView) itemView.findViewById(R.id.tvMainItem);
            sdvMainItem = (SimpleDraweeView) itemView.findViewById(R.id.sdvMainItem);
            sdvUserImg = (SimpleDraweeView) itemView.findViewById(R.id.sdvUserImg);
            tvUserName = (TextView) itemView.findViewById(R.id.tvUserName);
            layoutUser = (LinearLayout) itemView.findViewById(R.id.layoutUser);
        }
    }
}
