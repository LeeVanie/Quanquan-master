package com.lee.ttest.activity.set;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.lee.ttest.R;
import com.lee.ttest.adapter.ImageAdapter;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.draglayout.Callback;
import com.lee.ttest.draglayout.Invoker;
import com.lee.ttest.draglayout.Util;

import butterknife.BindView;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class PhotoActivity extends BaseActivity {
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ic_title)
    TextView icTitle;
    @BindView(R.id.gv_img)
    GridView gv_img;
    @BindView(R.id.iv_noimg)
    TextView iv_noimg;
    @BindView(R.id.add_photo)
    TextView addPhoto;
    private ImageAdapter adapter;


    @Override
    protected void initEventAndData() {

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initInjecter() {
        icTitle.setText("相册");

        gv_img.setFastScrollEnabled(true);
        adapter = new ImageAdapter(this);
        gv_img.setAdapter(adapter);
        gv_img.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //                Intent intent = new Intent(OCRActivity.this, ImageActivity.class);
                //                intent.putExtra("path", adapter.getItem(position));
                //                startActivity(intent);
            }
        });
        
        
    }
    
    @Override
    protected int getresLayoutID() {
        return R.layout.photo_activity;
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadImage();
    }

    private void loadImage() {
        new Invoker(new Callback() {
            @Override
            public boolean onRun() {
                adapter.addAll(Util.getGalleryPhotos(PhotoActivity.this));
                return adapter.isEmpty();
            }

            @Override
            public void onBefore() {

            }

            @Override
            public void onAfter(boolean b) {
                adapter.notifyDataSetChanged();
            }
        }).start();

    }

    
}
//jhfghfh