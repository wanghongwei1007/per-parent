package com.kalix.qiao.cms.entities;
import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Administrator on 2018/5/13.
 * 栏目表
 */
@Entity
@Table(name = "qiao_cms_forum")
public class ForumBean extends PersistentEntity {
    private String idcard;   //发帖人别名
    private String title;    //标题
    private String content;  //帖子内容
    private int type;        //留言分类（菜单id）
    private int postid;      //发帖id
    private String category; //审核标识
    private String categorytype; //类型标识
    private int userid;      //发帖人id
    private Date timenow;    //最新回复时间

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategorytype() {
        return categorytype;
    }

    public void setCategorytype(String categorytype) {
        this.categorytype = categorytype;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getTimenow() {
        return timenow;
    }

    public void setTimenow(Date timenow) {
        this.timenow = timenow;
    }
}
