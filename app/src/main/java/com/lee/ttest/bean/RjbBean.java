package com.lee.ttest.bean;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class RjbBean {
    
    private String title;
    private String content;
    private String time;

    public RjbBean(String title, String content, String time) {
        this.title = title;
        this.content = content;
        this.time = time;
    }

    public String getTime() {
    
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public RjbBean(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
    
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
//jhfghfh