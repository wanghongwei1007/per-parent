package com.kalix.qiao.cms.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Administrator on 2018/5/26 0026.
 */
@Entity
@Table(name = "qiao_cms_jsonTree")
public class JsonTreeBean {
    private Object label;
    private List children;

    public Object getLabel() {
        return label;
    }

    public void setLabel(Object label) {
        this.label = label;
    }

    public List getChildren() {
        return children;
    }

    public void setChildren(List children) {
        this.children = children;
    }
}
