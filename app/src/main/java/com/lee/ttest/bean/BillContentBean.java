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
public class BillContentBean implements Serializable {
    
    private String Type;
    private String name;
    private String money;
    private String beizhu;

    public BillContentBean(){
        
    }
    
    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public BillContentBean(String type, String name, String money, String beizhu) {
    
        Type = type;
        this.name = name;
        this.money = money;
        this.beizhu = beizhu;
    }
}
//jhfghfh