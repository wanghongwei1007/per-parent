package com.kalix.qiao.genealogy.api.dto;

import com.kalix.qiao.genealogy.entities.ClansmanBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangpeng on 2018/6/19 0026.
 * 族人参数列表封装
 */
public class ClansmanDTO extends ClansmanBean {
    private List<ClansmanDTO> children = new ArrayList<>();
    private String label;
    private long modelId;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public long getModelId() {
        return modelId;
    }

    public void setModelId(long modelId) {
        this.modelId = modelId;
    }

    public List<ClansmanDTO> getChildren() {
        return children;
    }

    public void setChildren(List<ClansmanDTO> children) {
        this.children = children;
    }
}
