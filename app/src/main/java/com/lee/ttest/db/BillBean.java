package com.lee.ttest.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
@Entity
public class BillBean {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "DATAS")
    private String datas;
    private String billType; //判断收支
    private String billShouContent;
    private String billChuContent;
    private float totalMoney;
    private String billTag;
    @Generated(hash = 1253943473)
    public BillBean(Long id, String datas, String billType, String billShouContent,
            String billChuContent, float totalMoney, String billTag) {
        this.id = id;
        this.datas = datas;
        this.billType = billType;
        this.billShouContent = billShouContent;
        this.billChuContent = billChuContent;
        this.totalMoney = totalMoney;
        this.billTag = billTag;
    }
    @Generated(hash = 562884989)
    public BillBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDatas() {
        return this.datas;
    }
    public void setDatas(String datas) {
        this.datas = datas;
    }
    public String getBillType() {
        return this.billType;
    }
    public void setBillType(String billType) {
        this.billType = billType;
    }
    public String getBillShouContent() {
        return this.billShouContent;
    }
    public void setBillShouContent(String billShouContent) {
        this.billShouContent = billShouContent;
    }
    public String getBillChuContent() {
        return this.billChuContent;
    }
    public void setBillChuContent(String billChuContent) {
        this.billChuContent = billChuContent;
    }
    public float getTotalMoney() {
        return this.totalMoney;
    }
    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }
    public String getBillTag() {
        return this.billTag;
    }
    public void setBillTag(String billTag) {
        this.billTag = billTag;
    }
  
    
}
//jhfghfh