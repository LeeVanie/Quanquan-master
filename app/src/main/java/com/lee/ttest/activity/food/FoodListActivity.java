package com.lee.ttest.activity.food;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


import com.lee.ttest.R;
import com.lee.ttest.adapter.FoodAdapter;
import com.lee.ttest.adapter.FoodListAdapter;
import com.lee.ttest.adapter.FoodTitleAdapter;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.bean.FoodDetailsBean;
import com.lee.ttest.widget.GifLoadingView;
import com.lee.ttest.widget.PullToRefreshLayout;

import junit.framework.Test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FoodListActivity extends BaseActivity implements PullToRefreshLayout.OnRefreshListener {
	private ListView listView;
	private PullToRefreshLayout ptrl;
	private boolean isFirstIn = true;
    private TextView back, title;
    private String urlStr, flag;
    private List<FoodDetailsBean> mFoodDetailsBeanList;
    private int pageNum = 1;
    private FoodListAdapter adapter;
    private LinearLayout noDatas;
    
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
        ptrl = ((PullToRefreshLayout) findViewById(R.id.refresh_view));
        ptrl.setOnRefreshListener(this);
        listView = (ListView) findViewById(R.id.content_view);
        back = (TextView) findViewById(R.id.back);
        title = (TextView) findViewById(R.id.title);
        noDatas = (LinearLayout) findViewById(R.id.no_datas);
        
        String titleStr = getIntent().getStringExtra("title");
        urlStr = getIntent().getStringExtra("url");
        flag = getIntent().getStringExtra("flag");
        title.setText(titleStr);
        initListView();
    }

    @Override
    protected int getresLayoutID() {
        return R.layout.activity_foodlist;
    }

    @Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		// 第一次进入自动刷新
		if (isFirstIn) {
			ptrl.autoRefresh();
			isFirstIn = false;
		}
	}

	/**
	 * ListView初始化方法
	 */
	private void initListView() {
        adapter = new FoodListAdapter(this);
        listView.setAdapter(adapter);
       
        LoadData loadDatas = new LoadData();
        loadDatas.execute();
        
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
                FoodDetailsBean bean = (FoodDetailsBean) parent.getItemAtPosition(position);
//                Intent intent = new Intent(FoodListActivity.this, FoodDetailsActivity.class);
                Intent intent = new Intent(FoodListActivity.this, FoodWebViewActivity.class);
                intent.putExtra("url", bean.getUrl());
                intent.putExtra("name", bean.getTitle());
                startActivity(intent);
			}
		});
	}
    class LoadData extends AsyncTask<String, Integer, Integer> {

        @Override
        protected void onPreExecute() {
//            gifLoadingView.show();
        }

        // 后台执行获取数据操作
        @Override
        protected Integer doInBackground(String... params) {
            getDatas(pageNum);
            return 0;
        }

        @Override
        protected void onPostExecute(Integer i) {
            // 线程执行完毕 绑定数据
            super.onPostExecute(i);
//            gifLoadingView.dismiss();
            if (mFoodDetailsBeanList.size() == 0){
                noDatas.setVisibility(View.VISIBLE);
                ptrl.setVisibility(View.GONE);
            } else {
                noDatas.setVisibility(View.GONE);
                ptrl.setVisibility(View.VISIBLE);
                adapter.setFoodDetailsBeanList(mFoodDetailsBeanList);
            }
        }
    }
    
    public void getDatas(int page){
        try {
            String url = "";
            if ("one".equals(flag)) {
                 url = urlStr + "/page/" + page + "/";
            } else if ("two".equals(flag)) {
                url = urlStr.substring(0, urlStr.length() - 5) + "-page-" + page + ".html";
            }
            Document document = Jsoup.connect(url).get();
            Elements topTab = document.select("div.ui_newlist_1").select("ul").select("li");
            if (page == 1) {
                mFoodDetailsBeanList = new ArrayList<>();
            }
            for (int i = 0; i < topTab.size(); i++) {
                FoodDetailsBean bean = new FoodDetailsBean();
                bean.setTitle(topTab.get(i).select("div.pic").select("a").attr("title"));
                String img = topTab.get(i).select("div.pic").select("img").attr("data-src");
                bean.setImg(img);
                bean.setUrl(topTab.get(i).select("div.pic").select("a").attr("href"));
                bean.setAuthor(topTab.get(i).select("div.detail").select("p.subline").select("a").text());
                bean.setAuthorUrl(topTab.get(i).select("div.detail").select("p.subline").select("a").attr("href"));
                bean.setContent(topTab.get(i).select("div.detail").select("p.subcontent").text());
                mFoodDetailsBeanList.add(bean);
            }
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void onRefresh(final PullToRefreshLayout pullToRefreshLayout) {
        // 下拉刷新操作
        new Handler() {
            @Override
            public void handleMessage(Message msg) {
                // 千万别忘了告诉控件刷新完毕了哦！
                pageNum = 1;
                LoadData loadDatas = new LoadData();
                loadDatas.execute();
                pullToRefreshLayout.refreshFinish(PullToRefreshLayout.SUCCEED);
            }
        }.sendEmptyMessageDelayed(0, 3000);
    }

    @Override
    public void onLoadMore(final PullToRefreshLayout pullToRefreshLayout) {
        // 加载操作
        new Handler()
        {
            @Override
            public void handleMessage(Message msg)
            {
                // 千万别忘了告诉控件加载完毕了哦！
                pageNum ++;
                LoadData loadDatas = new LoadData();
                loadDatas.execute();
                pullToRefreshLayout.loadmoreFinish(PullToRefreshLayout.SUCCEED);
            }
        }.sendEmptyMessageDelayed(0, 3000);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
