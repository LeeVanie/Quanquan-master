package com.lee.ttest.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;
    private String time;
    @Property(nameInDb = "USERNAME")
    private String title;
    private String content;
    private String color;
   private String tag;
@Generated(hash = 815530095)
public User(Long id, String time, String title, String content, String color,
        String tag) {
    this.id = id;
    this.time = time;
    this.title = title;
    this.content = content;
    this.color = color;
    this.tag = tag;
}
@Generated(hash = 586692638)
public User() {
}
public Long getId() {
    return this.id;
}
public void setId(Long id) {
    this.id = id;
}
public String getTime() {
    return this.time;
}
public void setTime(String time) {
    this.time = time;
}
public String getTitle() {
    return this.title;
}
public void setTitle(String title) {
    this.title = title;
}
public String getContent() {
    return this.content;
}
public void setContent(String content) {
    this.content = content;
}
public String getColor() {
    return this.color;
}
public void setColor(String color) {
    this.color = color;
}
public String getTag() {
    return this.tag;
}
public void setTag(String tag) {
    this.tag = tag;
}

    
}
//jhfghfh