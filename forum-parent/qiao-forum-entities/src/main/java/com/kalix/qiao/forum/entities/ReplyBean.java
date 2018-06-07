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
    private long userId;      //排序
    private String content;  //回复内容
    private Long isLeaf;    //是否是子节点
    private long parentId;    //父节点
    private long postId;      //发帖id
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

    public Long getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Long isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }
}