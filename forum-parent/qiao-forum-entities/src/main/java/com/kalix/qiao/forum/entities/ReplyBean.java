package com.kalix.qiao.forum.entities;
import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by sunli on 2018/5/13.
 * 回复管理表
 */
@Entity
@Table(name = "qiao_forum_reply")
public class ReplyBean extends PersistentEntity {
    private String username; //回复人姓名
    private int userId;      //排序
    private String content;  //回复内容
    private int parentId;    //父节点
    private int postId;      //发帖id
    private String category; //审核标识

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}