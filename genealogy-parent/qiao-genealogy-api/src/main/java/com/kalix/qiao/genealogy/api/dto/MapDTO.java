package com.kalix.qiao.genealogy.api.dto;


/**
 * Created by wangpeng on 2018/7/5
 * 地图数据封装
 */
public class MapDTO {
    private String fromCoord;
    private String toCoord;

    public String getFromCoord() {
        return fromCoord;
    }

    public void setFromCoord(String fromCoord) {
        this.fromCoord = fromCoord;
    }

    public String getToCoord() {
        return toCoord;
    }

    public void setToCoord(String toCoord) {
        this.toCoord = toCoord;
    }
}
