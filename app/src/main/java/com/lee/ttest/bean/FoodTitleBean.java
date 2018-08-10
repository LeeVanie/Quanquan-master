package com.lee.ttest.bean;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class FoodTitleBean {
    
    private String url;
    private String title;
    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public FoodTitleBean(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public FoodTitleBean() {
    }

    public String getUrl() {
    
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
//jhfghfh