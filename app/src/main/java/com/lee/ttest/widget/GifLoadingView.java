package com.lee.ttest.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lee.ttest.R;

/**
 * Created by Administrator on 15-7-22.
 */
public class GifLoadingView{
    private LinearLayout loadingView;
    private TextView loadingText;
    private ImageView loadingImageView;
    private int[] loadingImage = new int[]{
        R.drawable.gif_loading1, R.drawable.gif_loading2, R.drawable.gif_loading3, R.drawable
                .gif_loading4, R.drawable.gif_loading5, R.drawable.gif_loading6, R.drawable.gif_loading7};
    private int imagePosition;
    private int delayMillis = 50;
    private Handler handler;
    private boolean isShow = false;
    public  GifLoadingView(ViewGroup rootView,Context context, String message){
        loadingView = new LinearLayout(context);
        loadingView.setVisibility(View.GONE);
        loadingView.setOrientation(LinearLayout.VERTICAL);
        loadingView.setGravity(Gravity.CENTER);
        loadingView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        rootView.addView(loadingView);
        loadingText = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        loadingText.setLayoutParams(layoutParams);
        loadingText.setText(message);
        loadingText.setTextColor(Color.WHITE);
        loadingImageView = new ImageView(context);
        loadingImageView.setLayoutParams(layoutParams);
        if(this.loadingImage!=null&&loadingImage.length>0){
            imagePosition = 0;
            loadingImageView.setImageResource(loadingImage[imagePosition]);
        }
        loadingView.addView(loadingImageView);
        loadingView.addView(loadingText);
        // 实例化一个ColorDrawable颜色为半透明  
        ColorDrawable dw = new ColorDrawable(0x70000000);
        loadingView.setBackgroundDrawable(dw);
        handler = new Handler();
    }
    public void show(){
        isShow = true;
        loadingView.setVisibility(View.VISIBLE);
        handler.post(new Runnable() {
            @Override
            public void run() {
                imagePosition = imagePosition +1;
                if(imagePosition==loadingImage.length-1){
                    imagePosition = 0;
                }
                loadingImageView.setImageResource(loadingImage[imagePosition]);
                if(isShow){
                    handler.postDelayed(this,delayMillis);
                }
            }
        });
    }
    public void dismiss(){
        isShow = false;
        loadingView.setVisibility(View.GONE);
    }
    public boolean isShowIng(){
        return isShow;
    }
    public void setLoadingText(String text){
        loadingText.setText(text);
    }
    public void setDelayMillis(int delayMillis){
        this.delayMillis = delayMillis;
    }
    public void setCanceledOnTouchOutside(boolean isCancel){
        if(isCancel){
            loadingView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
        }
    }

}
