package com.kalix.qiao.forum.api.dto;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/6/1.
 */
public class ReplyForTreeTable {
    private String value; //id
    private String username; //回复人姓名
    private String content;  //回复内容
    private Date creationDate;// 创建日期
    private String category; //审核标识
    private List<ReplyForTreeTable>  children;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<ReplyForTreeTable> getChildren() {
        return children;
    }

    public void setChildren(List<ReplyForTreeTable> children) {
        this.children = children;
    }
}
