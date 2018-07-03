package com.kalix.qiao.system.station.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Created by sunli on 2018/7/3
 * 站长信息表
 */
@Entity
@Table(name = "qiao_station")
@Inheritance(strategy = InheritanceType.JOINED)
public class StationBean extends PersistentEntity{
    private String imgurl; //站长图片
    private String introduce; //站长介绍

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
