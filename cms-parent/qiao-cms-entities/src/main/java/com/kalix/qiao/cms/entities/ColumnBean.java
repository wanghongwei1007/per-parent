package com.kalix.qiao.cms.entities;
import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * Created by Administrator on 2018/5/13.
 * 栏目表
 */
@Entity
@Table(name = "qiao_cms_column")
public class ColumnBean extends PersistentEntity {

    private String name;//栏目名称
    private int sequence;//排序
    private String url;//栏目地址


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
