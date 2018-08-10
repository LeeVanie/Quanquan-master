package com.lee.ttest.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lee.ttest.R;
import com.lee.ttest.activity.food.FoodListActivity;
import com.lee.ttest.activity.food.FoodWebViewActivity;
import com.lee.ttest.activity.set.PhotoActivity;
import com.lee.ttest.activity.set.SetttingActivity;
import com.lee.ttest.adapter.WebViewFragmentPagerAdapter;
import com.lee.ttest.application.MyApplication;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.bsrgift.BSRGiftLayout;
import com.lee.ttest.draglayout.Callback;
import com.lee.ttest.draglayout.Invoker;
import com.lee.ttest.fragment.MainFragment;
import com.lee.ttest.fragment.MeFragment;
import com.lee.ttest.utils.GiftAnmManager;
import com.lee.ttest.utils.SharedPreferencesUtils;
import com.lee.ttest.utils.ToastUtils;
import com.lee.ttest.utils.bottompopfragmentmenu.BottomMenuFragment;
import com.lee.ttest.utils.bottompopfragmentmenu.MenuItem;
import com.lee.ttest.utils.bottompopfragmentmenu.MenuItemOnClickListener;
import com.lee.ttest.widget.AlertDialog;
import com.lee.ttest.widget.CircleImageView;
import com.lee.ttest.widget.DragLayout;
import com.lee.ttest.widget.SmallBang;
import com.lee.ttest.widget.SmallBangListener;
import com.nineoldandroids.view.ViewHelper;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    public static String TAG = "MainActivty";
    @BindView(R.id.iv_bottom)
    CircleImageView ivBottom;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.qianming)
    TextView qianming;
    @BindView(R.id.top)
    LinearLayout top;
    @BindView(R.id.tv_mail)
    TextView tv_mail;
    @BindView(R.id.lv)
    ListView lv;
    @BindView(R.id.iv_icon)
    ImageView iv_icon;
    @BindView(R.id.main_title)
    TextView mainTitle;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.zxys_tablayout)
    TabLayout zxysTablayout;
    @BindView(R.id.dl)
    DragLayout dl;
    @BindView(R.id.gift_layout)
    BSRGiftLayout giftLayout;


    private SmallBang mSmallBang;
    private List<Fragment> fragments;
    private String[] string;
    private AnimationDrawable AniDraw;
    private GiftAnmManager giftAnmManager;

    @Override
    protected void initEventAndData() {

        qianming.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showCancle();
            }
        });
        tv_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBSTGift();
                mSmallBang.bang(v, new SmallBangListener() {
                    @Override
                    public void onAnimationStart() {
                    }

                    @Override
                    public void onAnimationEnd() {
                    }
                });
            }
        });

        ivBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomMenuFragment bottomMenuFragment = new BottomMenuFragment();

                List<MenuItem> menuItemList = new ArrayList<MenuItem>();
                MenuItem menuItem1 = new MenuItem();
                menuItem1.setText("拍照");
                menuItem1.setStyle(MenuItem.MenuItemStyle.COMMON);
                MenuItem menuItem2 = new MenuItem();
                menuItem2.setText("从相册中选择");
                menuItem2.setStyle(MenuItem.MenuItemStyle.COMMON);
                menuItem1.setMenuItemOnClickListener(new MenuItemOnClickListener(bottomMenuFragment, menuItem1) {
                    @Override
                    public void onClickMenuItem(View v, MenuItem menuItem) {
                        getPicFromCamera();
                    }
                });
                menuItem2.setMenuItemOnClickListener(new MenuItemOnClickListener(bottomMenuFragment, menuItem1) {
                    @Override
                    public void onClickMenuItem(View v, MenuItem menuItem) {
                        getPicFromAlbm();
                    }
                });
                menuItemList.add(menuItem1);
                menuItemList.add(menuItem2);

                bottomMenuFragment.setMenuItems(menuItemList);

                bottomMenuFragment.show(getFragmentManager(), "BottomMenuFragment");
            }
        });
    }
    
    /**
     * 从相册获取图片
     */
    private void getPicFromAlbm() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, 1001);
    }
    
    /**
     * 从相机获取图片
     */
    private File tempFile;
    private void getPicFromCamera() {
        //用于保存调用相机拍照后所生成的文件
        tempFile = new File(Environment.getExternalStorageDirectory().getPath(), System.currentTimeMillis() + ".jpg");
        //跳转到调用系统相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //判断版本
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {   //如果在Android7.0以上,使用FileProvider获取Uri
            intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(MainActivity.this, "com.lee.ttest.fileprovider", tempFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, contentUri);
        } else {    //否则使用Uri.fromFile(file)方法获取Uri
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
        }
        startActivityForResult(intent, 1000);
    }
    
    
    public void showBSTGift() {
        giftAnmManager.showKiss();
    }

    public void getFragments() {
        fragments = new ArrayList<>();
        fragments.add(new MainFragment());
//        fragments.add(new MeFragment());
    }

    @Override
    protected void initInjecter() {
        //        animationTV.setBackgroundResource(R.drawable.load_animation);
        //        AniDraw = (AnimationDrawable)animationTV.getBackground();
        //        Timer timer = new Timer();
        //        TimerTask timerTask = new TimerTask() {
        //            @Override
        //            public void run() {
        //                AniDraw.start();
        //                }
        //        };
        //        timer.schedule(timerTask, 0, 5*1000);
        //        AniDraw.stop();

        mSmallBang = SmallBang.attach2Window(this);
        getFragments();
        tv_mail.setText("有惊喜");
        name.setText(SharedPreferencesUtils.getString(this, "loginname", ""));
        String s = SharedPreferencesUtils.getString(this, "signedit", "");
        String icon = SharedPreferencesUtils.getString(this, "ICON", "");
        if (null != icon && !icon.equals("")){
            ivBottom.setImageBitmap(getLoacalBitmap(icon));
        } else {
            ivBottom.setImageDrawable(getResources().getDrawable(R.drawable.default_face));
        }
        if ("".equals(s) || null == s) {
            s = "暂时还没有心情呢.....";
        }
        qianming.setText(s);
        rlTitle.setVisibility(View.GONE);
        initViews();
        string = new String[]{"主页"};
        zxysTablayout.addTab(zxysTablayout.newTab().setText(string[0]).setIcon(R.mipmap.ic_launcher));
//        zxysTablayout.addTab(zxysTablayout.newTab().setText(string[1]).setIcon(R.mipmap.ic_launcher));
        WebViewFragmentPagerAdapter adapter = new WebViewFragmentPagerAdapter(fragments, string, 
                getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        zxysTablayout.setupWithViewPager(viewpager);

        giftAnmManager = new GiftAnmManager(giftLayout, this);

    }

    /**
     * 加载本地图片
     * @param url
     * @return
     */
    public static Bitmap getLoacalBitmap(String url) {
        try {
            FileInputStream fis = new FileInputStream(url);
            return BitmapFactory.decodeStream(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void initViews() {
        dl.setDragListener(new DragLayout.DragListener() {
            @Override
            public void onOpen() {
                lv.smoothScrollToPosition(new Random().nextInt(30));
            }

            @Override
            public void onClose() {
                shake();
            }

            @Override
            public void onDrag(float percent) {
                ViewHelper.setAlpha(iv_icon, 1 - percent);
            }
        });
        lv.setAdapter(new ArrayAdapter<String>(MainActivity.this, R.layout.item_text, new String[]{"纪念", "安全中心", 
                "设置", "我的相册", "这么炫", "小游戏"}));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, BrowserActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, SetttingActivity.class));
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "他偷懒去了，我要好好教训他......", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Intent intent = new Intent();
                        intent.setType("image/*");
                        if (Build.VERSION.SDK_INT <19) {
                            intent.setAction(Intent.ACTION_GET_CONTENT);
                        }else {
                            intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
                        }
                        startActivity(intent);
                        break;
                    case 4:
//                        showIOSDialog("约会的小男孩", "星星点点");
                        Intent inten = new Intent(MainActivity.this, WebViewActivity.class);
                        inten.putExtra("url", "file:///android_asset/xuan/index.html");
                        startActivity(inten);
                        break;
                    case 5:
                        Intent intent5 = new Intent(MainActivity.this, WebViewActivity2.class);
                        intent5.putExtra("url", "file:///android_asset/wxgame/index.html");
                        startActivity(intent5);
                        break;
                }
            }
        });
        iv_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                dl.open();
            }
        });
    }
    
    public void showIOSDialog(String... string){
        BottomMenuFragment bottomMenuFragment = new BottomMenuFragment();
        List<MenuItem> menuItemList = new ArrayList<MenuItem>();
        MenuItem menuItem1 = new MenuItem();
        menuItem1.setText(string[0]);
        menuItem1.setStyle(MenuItem.MenuItemStyle.COMMON);
        MenuItem menuItem2 = new MenuItem();
        menuItem2.setText(string[1]);
        menuItem2.setStyle(MenuItem.MenuItemStyle.COMMON);
        menuItem1.setMenuItemOnClickListener(new MenuItemOnClickListener(bottomMenuFragment, menuItem1) {
            @Override
            public void onClickMenuItem(View v, MenuItem menuItem) {
                Intent inten = new Intent(MainActivity.this, WebViewActivity.class);
                inten.putExtra("url", "file:///android_asset/qixi/index.html");
                startActivity(inten);
            }
        });
        menuItem2.setMenuItemOnClickListener(new MenuItemOnClickListener(bottomMenuFragment, menuItem1) {
            @Override
            public void onClickMenuItem(View v, MenuItem menuItem) {
                Intent inten = new Intent(MainActivity.this, WebViewActivity.class);
                inten.putExtra("url", "file:///android_asset/xuan/index.html");
                startActivity(inten);
            }
        });
        menuItemList.add(menuItem1);
        menuItemList.add(menuItem2);

        bottomMenuFragment.setMenuItems(menuItemList);

        bottomMenuFragment.show(getFragmentManager(), "BottomMenuFragment");
    }
    
    
    @Override
    protected int getresLayoutID() {
        return R.layout.activity_main;
    }


    //记录用户首次点击返回键的时间
    private long firstTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - firstTime > 2000) {
                Toast.makeText(this, "亲...你忍心关闭我吗...", Toast.LENGTH_SHORT).show();
                firstTime = System.currentTimeMillis();
            } else {
                // 释放内存资源
                MyApplication.getApplication().finishActivity();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    public void showCancle() {
        final View contentView = LayoutInflater.from(this).inflate(R.layout.sign_edit, null);
        final ViewHolder holder = new ViewHolder(contentView);
        contentView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 
                LinearLayout.LayoutParams.WRAP_CONTENT));
        final AlertDialog dialog = new AlertDialog(this).builder().addView(contentView).setPositiveButton("写好了", 
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contentPopu = holder.askEdit.getText().toString().trim();
                if ("".equals(contentPopu) || null == contentPopu) {
                    ToastUtils.showToast(MainActivity.this, "亲...你还没写呢......");
                    return;
                } else {
                    qianming.setText(contentPopu);
                    SharedPreferencesUtils.saveString(MainActivity.this, "signedit", contentPopu);
                }
            }
        }).setNegativeButton("不想写了", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dialog.show();
    }

    private String contentPopu;

    static class ViewHolder {
        @BindView(R.id.ask_edit)
        EditText askEdit;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    private void shake() {
        
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadImage();
    }

    //    private ImageAdapter adapter;
    private void loadImage() {
        new Invoker(new Callback() {
            @Override
            public boolean onRun() {
                //                adapter.addAll(Util.getGalleryPhotos(OCRActivity.this));
                //                return adapter.isEmpty();
                return false;
            }

            @Override
            public void onBefore() {

            }

            @Override
            public void onAfter(boolean b) {
                //                adapter.notifyDataSetChanged();
                //                String s = "file://" + adapter.getItem(0);
                //                ImageLoader.getInstance().displayImage(s, iv_icon);
                //                ImageLoader.getInstance().displayImage(s, iv_bottom);
                shake();
            }
        }).start();

    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch (requestCode) {
            case 1000:   //调用相机后返回
                if (resultCode == RESULT_OK) {
                    //用相机返回的照片去调用剪裁也需要对Uri进行处理
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        Uri contentUri = FileProvider.getUriForFile(MainActivity.this, "com.lee.ttest.fileprovider", tempFile);
                        cropPhoto(contentUri);
                    } else {
                        cropPhoto(Uri.fromFile(tempFile));
                    }
                }
                break;
            case 1001:    //调用相册后返回
                if (resultCode == RESULT_OK) {
                    Uri uri = intent.getData();
                    cropPhoto(uri);
                }
                break;
            case 1002:     //调用剪裁后返回
                Bundle bundle = intent.getExtras();
                if (bundle != null) {
                    //在这里获得了剪裁后的Bitmap对象，可以用于上传
                    final Bitmap image = bundle.getParcelable("data");
                    //设置到ImageView上
                    ivBottom.setImageBitmap(image);
                    //也可以进行一些保存、压缩等操作后上传
                    String path = saveImage("crop", image);
                    SharedPreferencesUtils.saveString(MainActivity.this, "ICON", path);
                }
                break;
        }
    }

    /**
     * 保存图片到本地
     * @param name
     * @param bmp
     * @return
     */
    public String saveImage(String name, Bitmap bmp) {
        File appDir = new File(Environment.getExternalStorageDirectory().getPath());
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = name + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
            return file.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 裁剪图片
     */
    private void cropPhoto(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 300);
        intent.putExtra("outputY", 300);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 1002);
    }
}
