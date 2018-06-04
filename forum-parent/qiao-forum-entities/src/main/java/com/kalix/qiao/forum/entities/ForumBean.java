package com.kalix.qiao.forum.entities;
import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by sunli on 2018/5/13.
 * 留言管理表
 */
@Entity
@Table(name = "qiao_forum")
public class ForumBean extends PersistentEntity {
    private String idcard;   //发帖人别名
    private String title;    //标题
    private String content;  //帖子内容
    private String menuName; //留言分类（菜单id）
    private int category=0; //审核标识
    private String categorytype; //类型标识
    private Date timenow;    //最新回复时间

    public Date getTimenow() {
        return timenow;
    }

    public void setTimenow(Date timenow) {
        this.timenow = timenow;
    }

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

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getCategorytype() {
        return categorytype;
    }

    public void setCategorytype(String categorytype) {
        this.categorytype = categorytype;
    }

}