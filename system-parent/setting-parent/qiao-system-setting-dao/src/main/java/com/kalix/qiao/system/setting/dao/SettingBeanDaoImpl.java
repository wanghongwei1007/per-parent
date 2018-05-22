package com.kalix.qiao.system.setting.dao;


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

