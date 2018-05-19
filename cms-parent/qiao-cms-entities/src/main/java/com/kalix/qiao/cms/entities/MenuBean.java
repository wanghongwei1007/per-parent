package com.kalix.qiao.cms.entities;
import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
/**
 * Created by Administrator on 2018/5/13.
 * 菜单
 */
@Entity
@Table(name = "qiao_cms_menu")
public class MenuBean extends PersistentEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
