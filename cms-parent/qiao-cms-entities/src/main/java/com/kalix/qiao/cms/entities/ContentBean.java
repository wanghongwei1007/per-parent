package com.kalix.qiao.cms.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


/**
 * Created by Administrator on 2018/5/13.
 * 内容表
 */
@Entity
@Table(name = "qiao_cms_content")
public class ContentBean extends PersistentEntity {
    private String title;//标题
    private String subtitle;//次标题
    private String content;//内容
    private String compile;//编撰人姓名
    private int sequence;//排序
    private int menuid;//菜单id

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCompile() {
        return compile;
    }

    public void setCompile(String compile) {
        this.compile = compile;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getMenuid() {
        return menuid;
    }

    public void setMenuid(int menuid) {
        this.menuid = menuid;
    }
}
