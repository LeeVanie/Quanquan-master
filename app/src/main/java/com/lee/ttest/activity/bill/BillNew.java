package com.lee.ttest.activity.bill;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.lee.ttest.R;
import com.lee.ttest.adapter.BillNewAdapter;
import com.lee.ttest.base.BaseActivity;
import com.lee.ttest.common.BillInitDatas;
import com.lee.ttest.common.Common;
import com.lee.ttest.db.BillBean;
import com.lee.ttest.db.BillBeanDao;
import com.lee.ttest.db.GreenDaoUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class BillNew extends BaseActivity {

    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.money_edit)
    EditText moneyEdit;
    @BindView(R.id.gridview)
    GridView gridview;
    @BindView(R.id.cancle)
    Button cancle;
    @BindView(R.id.queding)
    Button queding;
    @BindView(R.id.more)
    ImageView more;
    @BindView(R.id.image_selected)
    ImageView imageSelected;
    @BindView(R.id.text_selected)
    TextView textSelected;
    @BindView(R.id.beizhu)
    TextView beizhu;
    @BindView(R.id.two_page)
    LinearLayout twoPage;
    @BindView(R.id.title_all)
    LinearLayout titleAll;
    @BindView(R.id.all)
    LinearLayout all;

    private BillNewAdapter mBillNewAdapter;
    private int selectorPosition = 0;
    private String flag;
    private int[] imgs;
    private int[] imgSelected;
    private String[] texts;
    private BillBean mBillBean;
    private BillBeanDao mBillBeanDao;
    private String DATA;
    private String TYPE;
    private String SHOUCONTENT;
    private String CHUCONTENT;
    private List<BillBean> mBean;


    @Override
    protected void initEventAndData() {
        Common.REMARK = "";
    }

    @Override
    protected void onResume() {
        super.onResume();

        beizhu.setText(Common.REMARK);
    }

    @Override
    protected void initInjecter() {
        DATA = getIntent().getExtras().getString("DATA");
        TYPE = getIntent().getExtras().getString("TYPE");
        name.setText(TYPE);
        SHOUCONTENT = getIntent().getExtras().getString("SHOUCONTENT");
        CHUCONTENT = getIntent().getExtras().getString("CHUCONTENT");

        mBillBeanDao = GreenDaoUtils.getSingleTon().getmDaoSession().getBillBeanDao();

        if ("收".equals(TYPE)) {
            more.setVisibility(View.GONE);
            titleAll.setBackgroundColor(getResources().getColor(R.color.qing));
            datas(BillInitDatas.shouImgs, BillInitDatas.shouSelectedImgs, BillInitDatas.shouText);
            imageSelected.setImageResource(BillInitDatas.shouSelectedImgs[0]);
            textSelected.setText(BillInitDatas.shouText[0]);
        } else if ("出".equals(TYPE)) {
            more.setVisibility(View.VISIBLE);
            titleAll.setBackgroundColor(getResources().getColor(R.color.orange));
            datas(BillInitDatas.zhiImgsRC, BillInitDatas.zhiSelectedImgsRC, BillInitDatas.zhiTextRC);
        }

    }

    @Override
    protected int getresLayoutID() {
        return R.layout.bill_new;
    }

    @OnClick({R.id.cancle, R.id.queding, R.id.more, R.id.beizhu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cancle:
                finish();
                break;
            case R.id.queding:
                save();
                break;
            case R.id.more:
                setPopuWindow(more);
                break;
            case R.id.beizhu:
                startActivity(new Intent(this, BillRemark.class));
                break;
        }
    }

    public boolean Data(){
        mBean = mBillBeanDao.loadAll();
        for (int i = 0; i < mBean.size(); i++) {
            if (DATA.equals(mBean.get(i).getDatas())){
                return true;
            }
        }
        return false;
    }

    public void save() {
        int total = 0;
        String editmoney = moneyEdit.getText().toString().trim();
        String bz = beizhu.getText().toString().trim();
        if ("".equals(editmoney) || null == editmoney) {
            editmoney = String.valueOf(0);
        }
        if ("".equals(bz) || null == bz) {
            bz = "$$$$";
        }
        String content = editmoney + "@" + textSelected.getText().toString().trim() + "@" + bz;

        if ("收".equals(TYPE)) {
            if (Data()) {
                mBillBean = mBillBeanDao.queryBuilder().where(BillBeanDao.Properties.Datas.eq(DATA)).build().unique();
                if (!"".equals(mBillBean.getBillShouContent())) {
                    SHOUCONTENT = mBillBean.getBillShouContent() + "#" + content;
                    if (mBillBean != null) {
                        mBillBean.setBillType(TYPE);
                        mBillBean.setBillShouContent(SHOUCONTENT);
                        mBillBean.setBillChuContent(mBillBean.getBillChuContent());
                        mBillBean.setTotalMoney(total);
                        mBillBeanDao.update(mBillBean);
                    }
                } else {
                    if (!"".equals(mBillBean.getBillChuContent())) {
                        mBillBean = mBillBeanDao.queryBuilder().where(BillBeanDao.Properties.Datas.eq(DATA)).build().unique();
                        if (mBillBean != null) {
                            mBillBean.setBillType(TYPE);
                            mBillBean.setBillShouContent(content);
                            mBillBean.setBillChuContent(mBillBean.getBillChuContent());
                            mBillBean.setTotalMoney(total);
                            mBillBeanDao.update(mBillBean);
                        }
                    }
                }
            } else {
                mBillBean = new BillBean(null, DATA, TYPE, content, CHUCONTENT, total, "tag");
                mBillBeanDao.insert(mBillBean);

            }
        } else if ("出".equals(TYPE)) {
            if (Data()) {
                mBillBean = mBillBeanDao.queryBuilder().where(BillBeanDao.Properties.Datas.eq(DATA)).build().unique();
                if (!"".equals(mBillBean.getBillChuContent())) {
                    CHUCONTENT = mBillBean.getBillChuContent() + "#" + content;
                    if (mBillBean != null) {
                        mBillBean.setBillType(TYPE);
                        mBillBean.setBillShouContent(mBillBean.getBillShouContent());
                        mBillBean.setBillChuContent(CHUCONTENT);
                        mBillBean.setTotalMoney(total);
                        mBillBeanDao.update(mBillBean);
                    }
                } else {
                    if (!"".equals(mBillBean.getBillShouContent())) {
                        mBillBean = mBillBeanDao.queryBuilder().where(BillBeanDao.Properties.Datas.eq(DATA)).build().unique();
                        if (mBillBean != null) {
                            mBillBean.setBillType(TYPE);
                            mBillBean.setBillShouContent(mBillBean.getBillShouContent());
                            mBillBean.setBillChuContent(content);
                            mBillBean.setTotalMoney(total);
                            mBillBeanDao.update(mBillBean);
                        }
                    }
                }
            } else {
                mBillBean = new BillBean(null, DATA, TYPE, SHOUCONTENT, content, total, "tag");
                mBillBeanDao.insert(mBillBean);
            }

        }

        Intent intent = new Intent(this, BillDetails.class);
        intent.putExtra("DATA", DATA);
        startActivity(intent);
        finish();

    }


    public void setPopuWindow(View view) {
        final View contentView = LayoutInflater.from(this).inflate(R.layout.bill_new_fenlei_popu, null);
        PopupWindow popupWindow = new PopupWindow(contentView, 350, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.white));
        if (!popupWindow.isShowing()) {
            popupWindow.showAsDropDown(view);
        }
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

            }
        });
        ViewHolder holder = new ViewHolder(contentView);
        holder.richang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datas(BillInitDatas.zhiImgsRC, BillInitDatas.zhiSelectedImgsRC, BillInitDatas.zhiTextRC);
            }
        });
        holder.zhuangxiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datas(BillInitDatas.zhiImgsZX, BillInitDatas.zhiSelectedImgsZX, BillInitDatas.zhiTextZX);
            }
        });
        holder.xuexi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datas(BillInitDatas.zhiImgsXX, BillInitDatas.zhiSelectedImgsXX, BillInitDatas.zhiTextXX);
            }
        });
        holder.hunli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datas(BillInitDatas.zhiImgsHL, BillInitDatas.zhiSelectedImgsHL, BillInitDatas.zhiTExtHL);
            }
        });
    }

    public void datas(int[] im, final int[] ims, final String[] te) {
        mBillNewAdapter = new BillNewAdapter(this, im, ims, te);
        gridview.setAdapter(mBillNewAdapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mBillNewAdapter.changeState(position);
                selectorPosition = position;
                imageSelected.setImageResource(ims[position]);
                textSelected.setText(te[position]);
                mBillNewAdapter.notifyDataSetChanged();
            }
        });
    }

    static class ViewHolder {
        @BindView(R.id.richang)
        TextView richang;
        @BindView(R.id.xuexi)
        TextView xuexi;
        @BindView(R.id.zhuangxiu)
        TextView zhuangxiu;
        @BindView(R.id.hunli)
        TextView hunli;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
//jhfghfh