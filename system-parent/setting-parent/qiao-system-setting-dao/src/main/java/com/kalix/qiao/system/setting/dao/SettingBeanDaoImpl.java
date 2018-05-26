package com.kalix.qiao.system.setting.dao;
/**
 * Created by sunli on 2018/5/13.
 */

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.qiao.system.setting.api.dao.ISettingBeanDao;
import com.kalix.qiao.system.setting.entities.SettingBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SettingBeanDaoImpl extends GenericDao<SettingBean, Long> implements ISettingBeanDao {
    @Override
    @PersistenceContext(unitName = "setting-unit")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}

