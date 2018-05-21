package com.kalix.qiao.genealogy.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2018/5/20 0020.
 */
@Entity
@Table(name = "qiao_location")
public class LocationBean extends PersistentEntity {
    private Double destinationlatitude;//终点纬度
    private Double destinationlongitude;//终点经度
    private int genealogynameid;//家谱ID
    private Double startlatitude;//起始纬度
    private Double startlongitude;//起始经度

    public Double getDestinationlatitude() {
        return destinationlatitude;
    }

    public void setDestinationlatitude(Double destinationlatitude) {
        this.destinationlatitude = destinationlatitude;
    }

    public Double getDestinationlongitude() {
        return destinationlongitude;
    }

    public void setDestinationlongitude(Double destinationlongitude) {
        this.destinationlongitude = destinationlongitude;
    }

    public int getGenealogynameid() {
        return genealogynameid;
    }

    public void setGenealogynameid(int genealogynameid) {
        this.genealogynameid = genealogynameid;
    }

    public Double getStartlatitude() {
        return startlatitude;
    }

    public void setStartlatitude(Double startlatitude) {
        this.startlatitude = startlatitude;
    }

    public Double getStartlongitude() {
        return startlongitude;
    }

    public void setStartlongitude(Double startlongitude) {
        this.startlongitude = startlongitude;
    }
}
