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
@Table(name = "qiao_setting_blogroll")
@ApiModel("友情链接<br>BlogrollBean")
public class BlogrollBean extends PersistentEntity {
    @ApiModelProperty("友情链接文字")
    private String linktext;   //友情链接文字
    @ApiModelProperty("跳转地址")
    private String texturl; //跳转地址

    public String getLinktext() {
        return linktext;
    }

    public void setLinktext(String linktext) {
        this.linktext = linktext;
    }

    public String getTexturl() {
        return texturl;
    }

    public void setTexturl(String texturl) {
        this.texturl = texturl;
    }


    @Override
    public String toString() {
        return "BlogrollBean{" +
                "linktext='" + linktext + '\'' +
                ", texturl='" + texturl + '\'' +
                '}';
    }
}
