package com.kalix.qiao.forum.api.dto;

import java.util.Date;
import java.util.List;

/**
 * Created by sunli on 2018/6/1.
 */
public class ReplyForTreeTable{
    private long id;
    private String username; //回复人姓名
    private String content;  //回复内容
    private String  category; //审核标识
    private Date creationDate; //回复时间
    private Boolean leaf; //是否是叶子节点
    private Long parentId;  // 父节点
    private String parentName; //父节点姓名
    private List<ReplyForTreeTable>  children;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    public List<ReplyForTreeTable> getChildren() {
        return children;
    }

    public void setChildren(List<ReplyForTreeTable> children) {
        this.children = children;
    }
}
