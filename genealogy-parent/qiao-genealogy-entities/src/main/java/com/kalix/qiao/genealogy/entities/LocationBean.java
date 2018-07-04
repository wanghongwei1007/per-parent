package com.kalix.qiao.genealogy.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by wangpeng on 2018/7/3
 */
@Entity
@Table(name = "qiao_genealogy_location")
public class LocationBean extends PersistentEntity {
    private long genealogyId;//家谱ID
    private String startProvince;
    private String startCity;
    private String endProvince;
    private String endCity;

    public long getGenealogyId() {
        return genealogyId;
    }

    public void setGenealogyId(long genealogyId) {
        this.genealogyId = genealogyId;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

    public String getStartProvince() {
        return startProvince;
    }

    public void setStartProvince(String startProvince) {
        this.startProvince = startProvince;
    }

    public String getEndProvince() {
        return endProvince;
    }

    public void setEndProvince(String endProvince) {
        this.endProvince = endProvince;
    }
}
