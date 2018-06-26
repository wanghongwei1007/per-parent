package com.kalix.qiao.genealogy.api.dto;


/**
 * Created by wangpeng on 2018/6/23 0026.
 * 字辈参数列表封装
 */
public class SelectDTO {
    private String label;
    private String value;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
