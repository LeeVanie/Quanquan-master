package com.lee.ttest.activity.food;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.lee.ttest.R;
import com.lee.ttest.adapter.FoodAdapter;
import com.lee.ttest.adapter.FoodTitleAdapter;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.bean.FoodTitleBean;
import com.lee.ttest.widget.GifLoadingView;
import com.lee.ttest.widget.MyGridView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class FoodActivity extends BaseActivity {

    @BindView(R.id.back)
    TextView back;
    @BindView(R.id.list_title)
    ListView listTitle;
    @BindView(R.id.gridview)
    GridView gridview;

    private FoodAdapter mAdapter;
    private FoodTitleAdapter mTitleAdapter;
    private Map<String, List<FoodTitleBean>> mFoodTitleBeen;
    private List<String> title;
    private List<FoodTitleBean> bean;
    private GifLoadingView gifLoadingView;
    @Override
    protected void initEventAndData() {
        listTitle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mAdapter = new FoodAdapter(FoodActivity.this);
                gridview.setAdapter(mAdapter);
                mAdapter.setItems(mFoodTitleBeen.get(title.get(position)));
            }
        });
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FoodTitleBean bean = (FoodTitleBean) parent.getItemAtPosition(position);
                //                Intent intent = new Intent(FoodActivity.this, WebViewActivity.class);
                //                intent.putExtra("url", bean.getUrl());
                //                startActivity(intent);
                Intent intent = new Intent(FoodActivity.this, FoodListActivity.class);
                intent.putExtra("url", bean.getUrl());
                intent.putExtra("title", bean.getTitle());
                intent.putExtra("flag", bean.getFlag());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initInjecter() {
        gifLoadingView = new GifLoadingView((android.view.ViewGroup) findViewById(R.id.main_content).getRootView()
                ,this,"正在为您加载....");
        gifLoadingView.setCanceledOnTouchOutside(true);
        mTitleAdapter = new FoodTitleAdapter(this);
        LoadData loadDatas = new LoadData();
        loadDatas.execute();
    }

    @Override
    protected int getresLayoutID() {
        return R.layout.activity_food;
    }

    private void getDatas() {
        try {
            Document document = Jsoup.connect("http://home.meishichina.com/recipe-type.html").get();
            Elements topTab = document.select("div.category_sub");
            //            Log.d("FoodActivity", topTab.toString());
            title = new ArrayList<>();
            mFoodTitleBeen = new HashMap<>();
            String titleStr = "";
            String titleContent = "";
            for (int i = 0; i < topTab.size(); i++) {
                titleStr = "";
                titleStr = topTab.get(i).select("h3").text();
                title.add(titleStr);
                bean = new ArrayList<>();
                Elements body = topTab.get(i).select("ul").select("li");
                for (int j = 0; j < body.size(); j++) {
                    FoodTitleBean titleBean = new FoodTitleBean();
                    titleBean.setUrl(body.get(j).select("a").attr("href"));
                    titleContent = "";
                    titleContent = body.get(j).select("a").attr("title");
                    if ("".equals(titleContent)){
                        titleContent = body.get(j).select("a").text();
                        titleBean.setFlag("two");
                    } else {
                        titleBean.setFlag("one");
                    }
                    titleBean.setTitle(titleContent);
                    bean.add(titleBean);
                }
                mFoodTitleBeen.put(titleStr, bean);
            }

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
            listTitle.setAdapter(mTitleAdapter);
            mTitleAdapter.setDatas(title);
            mAdapter = new FoodAdapter(FoodActivity.this);
            gridview.setAdapter(mAdapter);
            mAdapter.setItems(mFoodTitleBeen.get(title.get(0)));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        gifLoadingView = null;
    }
}
//jhfghfh