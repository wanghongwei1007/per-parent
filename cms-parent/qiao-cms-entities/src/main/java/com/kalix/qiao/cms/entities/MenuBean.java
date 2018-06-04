package com.kalix.qiao.cms.entities;
import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by Administrator on 2018/5/13.
 * 菜单
 */
@Entity
@Table(name = "qiao_cms_menu")
public class MenuBean extends PersistentEntity {
    private boolean message; //是否留言
    private String name;//菜单名称
    private int columnId;//栏目id
    private int sequence;//排序
    private boolean show;//是否显示
    private String url;//菜单地址

    @Transient
    private String columnName;
    
    @Transient
    private String viewURL;

    public String getViewURL() {
        return viewURL;
    }

    public void setViewURL(String viewURL) {
        this.viewURL = viewURL;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColumnId() {
        return columnId;
    }

    public void setColumnId(int columnId) {
        this.columnId = columnId;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public boolean isMessage() {
        return message;
    }

    public void setMessage(boolean message) {
        this.message = message;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
