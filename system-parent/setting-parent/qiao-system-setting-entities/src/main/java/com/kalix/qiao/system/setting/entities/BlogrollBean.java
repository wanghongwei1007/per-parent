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
    private String text;   //友情链接文字
    @ApiModelProperty("跳转地址")
    private String texturl; //跳转地址

    public String getTexturl() {
        return texturl;
    }

    public void setTexturl(String texturl) {
        this.texturl = texturl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "BlogrollBean{" +
                "text='" + text + '\'' +
                ", texturl='" + texturl + '\'' +
                '}';
    }
}
