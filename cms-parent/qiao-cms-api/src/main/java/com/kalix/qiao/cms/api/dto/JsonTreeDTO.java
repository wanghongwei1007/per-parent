package com.kalix.qiao.cms.api.dto;

import com.kalix.framework.core.api.web.model.BaseDTO;

import java.util.List;

/**
 * Created by wangpeng on 2018/5/26 0026.
 * 树形列表参数封装
 */
public class JsonTreeDTO extends BaseDTO {
    private String label;
    private String flag;
    private long modelId;
    private List<JsonTreeDTO> children;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

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

    public List getChildren() {
        return children;
    }

    public void setChildren(List children) {
        this.children = children;
    }
}
