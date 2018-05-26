package com.kalix.qiao.system.setting.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Created by sunli on 2018/5/16.
 * 公司信息表
 */
@Entity
@Table(name = "qiao_setting")
@Inheritance(strategy = InheritanceType.JOINED)
public class SettingBean extends PersistentEntity {
    private String site;    // 公司网址
    private String phone;   // 电话

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
