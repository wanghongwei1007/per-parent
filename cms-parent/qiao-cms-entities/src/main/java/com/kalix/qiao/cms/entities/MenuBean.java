package com.kalix.qiao.cms.entities;
import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
/**
 * Created by Administrator on 2018/5/13.
 */
@Entity
@Table(name = "qiao_menu")
public class MenuBean extends PersistentEntity {
    private Long id;
}
