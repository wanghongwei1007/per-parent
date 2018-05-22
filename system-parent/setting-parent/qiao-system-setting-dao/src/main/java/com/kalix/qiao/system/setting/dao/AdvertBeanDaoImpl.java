package com.kalix.qiao.system.setting.dao;


import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.qiao.system.setting.api.dao.IAdvertBeanDao;
import com.kalix.qiao.system.setting.entities.AdvertBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AdvertBeanDaoImpl extends GenericDao<AdvertBean, Long> implements IAdvertBeanDao {
    @Override
    @PersistenceContext(unitName = "setting-unit")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}

