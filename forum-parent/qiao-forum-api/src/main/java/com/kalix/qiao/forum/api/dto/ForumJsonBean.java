package com.kalix.qiao.forum.api.dto;

import java.util.List;

/**
 * Created by Administrator on 2018/6/1.
 */
public class ForumJsonBean {
    private long value;
    private String label;
    private String content;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
