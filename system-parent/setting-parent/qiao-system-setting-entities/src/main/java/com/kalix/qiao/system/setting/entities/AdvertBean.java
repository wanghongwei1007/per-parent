package com.kalix.qiao.system.setting.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @类描述：
 * @创建人：
 * @创建时间：
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
@Entity
@Table(name = "qiao_setting_advert")
@ApiModel("广告管理<br>AdvertBean")
public class AdvertBean extends PersistentEntity {
    @ApiModelProperty("广告图片")
    private String imgurl;   //广告图片
    @ApiModelProperty("广告链接")
    private String link; //广告链接
    @ApiModelProperty("广告名称")
    private String name; //广告名称

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AdvertBean{" +
                "imgurl='" + imgurl + '\'' +
                ", link'" + link + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
