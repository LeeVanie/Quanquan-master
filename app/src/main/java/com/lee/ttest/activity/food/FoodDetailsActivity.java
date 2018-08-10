package com.lee.ttest.activity.food;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lee.ttest.R;
import com.lee.ttest.adapter.FoodAdapter;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.bean.FoodBean;
import com.lee.ttest.bean.FoodBuzhouBean;
import com.lee.ttest.bean.FoodShicaiBean;
import com.lee.ttest.bean.FoodTitleBean;
import com.lee.ttest.widget.GifLoadingView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
public class FoodDetailsActivity extends BaseActivity {
    @BindView(R.id.back)
    TextView back;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.food_image)
    SimpleDraweeView foodImage;
    @BindView(R.id.food_title)
    TextView foodTitle;
    @BindView(R.id.content)
    TextView content;
    @BindView(R.id.title_shicai)
    TextView titleShicai;
    @BindView(R.id.shicai)
    LinearLayout shicai;
    @BindView(R.id.title_buzhou)
    TextView titleBuzhou;
    @BindView(R.id.buzhou)
    LinearLayout buzhou;
    @BindView(R.id.content_tishi)
    TextView contentTishi;
    
    private String urlStr, name;
    private GifLoadingView gifLoadingView;
    private FoodBean bean;
    private List<FoodBuzhouBean> buzhouBean;
    private List<FoodShicaiBean> shicaiBean;
    @Override
    protected void initEventAndData() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void initInjecter() {
        urlStr = getIntent().getStringExtra("url");
        name = getIntent().getStringExtra("name");
        foodTitle.setText(name);
        title.setText(name);
        titleBuzhou.setText(name + "的做法步骤");
        gifLoadingView = new GifLoadingView((android.view.ViewGroup) findViewById(R.id.main_content).getRootView()
                ,this,"正在为您加载....");
        gifLoadingView.setCanceledOnTouchOutside(true);

        LoadData loadDatas = new LoadData();
        loadDatas.execute();
    }

    @Override
    protected int getresLayoutID() {
        return R.layout.food_details;
    }

    private void getDatas() {
        try {
            bean = new FoodBean();
            Document document = Jsoup.connect(urlStr).get();
            Elements topTab = document.select("div.r_info_mainpic").select("mip-img");
            bean.setFoodImg(document.select("div.r_info_mainpic").select("mip-img").attr("src"));
            bean.setContent(document.select("p.ibox").text());
            Elements shicaiEle = document.select("div.clist_1").select("ul").select("li");
            shicaiBean = new ArrayList<>();
            for (int i = 0; i < shicaiEle.size(); i++) {
                FoodShicaiBean shicaiBean = new FoodShicaiBean();
                shicaiBean.setImg(shicaiEle.select("span.category_s1").select("b").text());
                shicaiBean.setContent(shicaiEle.select("span.category_s2").text());
                this.shicaiBean.add(shicaiBean);
            }
            Elements buzhouEle = document.select("div.steplist").select("ul").select("li");
            buzhouBean = new ArrayList<>();
            for (int i = 0; i < buzhouEle.size(); i++) {
                FoodBuzhouBean buzhouBean = new FoodBuzhouBean();
                buzhouBean.setImg(buzhouEle.select("div.recipeStep_img").select("img").attr("src"));
                buzhouBean.setContent(buzhouEle.select("div.recipeStep_word").text());
                this.buzhouBean.add(buzhouBean);
            }
            bean.setFoodqiaomen(topTab.select("div.recipeTip").text());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    class LoadData extends AsyncTask<String, Integer, Integer> {

        @Override
        protected void onPreExecute() {
            gifLoadingView.show();
        }

        // 后台执行获取数据操作
        @Override
        protected Integer doInBackground(String... params) {
            getDatas();
            return 0;
        }

        @Override
        protected void onPostExecute(Integer i) {
            // 线程执行完毕 绑定数据
            super.onPostExecute(i);
            gifLoadingView.dismiss();
            foodImage.setImageURI(bean.getFoodImg());
            content.setText(bean.getContent());
            contentTishi.setText(bean.getFoodqiaomen());
            LayoutInflater inflater = LayoutInflater.from(FoodDetailsActivity.this);
            View shicaiView = inflater.inflate(R.layout.food_details_shicai, shicai, false);
            
        }
    }
    
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        
        
    }
}
//jhfghfh