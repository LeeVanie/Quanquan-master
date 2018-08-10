package com.lee.ttest.bean;

import java.io.Serializable;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class BillListBean {
    
    
    private String type;
    private String className;
    private float money;
    private String remark;
    private String data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public BillListBean(String type, String className, float money, String remark, String data) {
    
        this.type = type;
        this.className = className;
        this.money = money;
        this.remark = remark;
        this.data = data;
    }

    public BillListBean() {
    }
}
//jhfghfh