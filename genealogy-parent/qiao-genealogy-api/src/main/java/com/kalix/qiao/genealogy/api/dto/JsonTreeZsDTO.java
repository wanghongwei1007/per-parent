package com.kalix.qiao.genealogy.api.dto;

import com.kalix.framework.core.api.web.model.BaseDTO;
import java.util.List;
/**
 * Created by wangpeng on 2018/5/26 0026.
 * 树形列表参数封装
 */
public class JsonTreeZsDTO{
    private String label;
    private long modelId;
    private List<JsonTreeZsDTO> children;

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

    public List<JsonTreeZsDTO> getChildren() {
        return children;
    }

    public void setChildren(List<JsonTreeZsDTO> children) {
        this.children = children;
    }
}
