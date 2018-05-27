package com.kalix.qiao.cms.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Administrator on 2018/5/26 0026.
 */
@Entity
@Table(name = "qiao_cms_jsonBean")
public class JsonClassBean {
    private String value;
    private String label;
    private List children;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List getChildren() {
        return children;
    }

    public void setChildren(List children) {
        this.children = children;
    }
}
