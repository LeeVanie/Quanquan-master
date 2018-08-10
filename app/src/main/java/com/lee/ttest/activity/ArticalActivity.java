package com.lee.ttest.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.lee.ttest.R;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.bean.ArticleBean;
import com.lee.ttest.utils.NetWorkUtils;
import com.lee.ttest.widget.GifLoadingView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
public class ArticalActivity extends BaseActivity {

    @BindView(R.id.htmlTv)
    TextView htmlTextView;

    private final static String TAG = "ArticalActivity";

    ExecutorService executorService = Executors.newSingleThreadExecutor();

    //主页地址
    static final String HomePageUrl = "http://www.meiriyiwen.com";
    //随机页地址
    static final String RandomPageUrl = "http://meiriyiwen.com/random";
    //请求数据地址
    String PostUrl = HomePageUrl;

    //前一次点击时间
    long lastHtmlClickTime = 0;
    //前一次响应双击的时间
    long lastDubbleTime = 0;
    @BindView(R.id.back)
    TextView back;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.share)
    TextView share;
    @BindView(R.id.main_content)
    LinearLayout mainContent;


    private GifLoadingView gifLoadingView;

    @Override
    protected void initEventAndData() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onShare();
            }
        });
    }

    @Override
    protected void initInjecter() {
        title.setText("每日一文");
        gifLoadingView = new GifLoadingView((ViewGroup) findViewById(R.id.main_content).getRootView(), this, 
                "双击空白处可刷新哦！！！");
        gifLoadingView.setCanceledOnTouchOutside(true);
        if (NetWorkUtils.isNetworkConnected(this)) {
            new AsyncParseTask().executeOnExecutor(executorService);
        } else {
            Toast.makeText(this, "网络已断开连接......", Toast.LENGTH_SHORT).show();
            return;
        }

    }

    @Override
    protected int getresLayoutID() {
        return R.layout.article;
    }
    
    public void onHtmlClick(View v) {
        long now = System.currentTimeMillis();
        if (now - lastHtmlClickTime < 900) {

            //两次点击时间差小于900ms为双击
            if (now - lastDubbleTime > 900) {
                //过滤连续点击,两次双击时间差大于900ms为有效
                getRandomArticle();
                lastDubbleTime = now;
            }
            lastHtmlClickTime = now;
        } else {
            lastHtmlClickTime = now;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        executorService.shutdown();
    }

    public void onShare() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, PostUrl);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(Intent.createChooser(intent, "分享该链接"));
    }

    /**
     * 获取随机文章
     */
    private void getRandomArticle() {
        PostUrl = RandomPageUrl;
        if (NetWorkUtils.isNetworkConnected(this)) {
            new AsyncParseTask().executeOnExecutor(executorService);
        } else {
            Toast.makeText(this, "网络已断开连接......", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    /**
     * 请求及解析数据
     *
     * @return
     */
    public Element parseDoc() {
        try {
            Document doc = Jsoup.parse(new URL(PostUrl), 10 * 1000);
            System.out.println(doc.toString());
            Elements elements;
            if (PostUrl.equals(HomePageUrl)) {
                elements = doc.select("div.container");
                return elements.size() > 0 ? elements.get(0) : null;

            } else {
                Element article_show = doc.getElementById("article_show");
                return article_show;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public class AsyncParseTask extends AsyncTask<String, Void, Element> {

        @Override
        protected Element doInBackground(String... params) {

            return parseDoc();
        }

        public AsyncParseTask() {
            super();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            gifLoadingView.show();
        }

        @Override
        protected void onPostExecute(Element element) {
            super.onPostExecute(element);
            Log.i(TAG, "parseTask  onPostExecute!");
            gifLoadingView.dismiss(); 
            
            if (element != null) {
                String string = element.toString();
                Spanned spanned;
                spanned = Html.fromHtml(string.replace("随机文章", "")
                        .replace("<p style=\"color: red;" +
                                "\">请至应用商店搜索\"每日一文\"下载或者访问<a href=\"http://meiriyiwen.com/app\">http://meiriyiwen" +
                                ".com/app</a> &nbsp; 下载最新版本谢谢 : )</p>", ""));
                
                htmlTextView.setText(spanned);
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            Log.i(TAG, "parseTask update progress!");
        }

        @Override
        protected void onCancelled(Element element) {
            super.onCancelled(element);
            Log.i(TAG, "parseTask cancled! with argument");
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            Log.i(TAG, "parseTask cancled!");
        }
    }

}
//jhfghfh