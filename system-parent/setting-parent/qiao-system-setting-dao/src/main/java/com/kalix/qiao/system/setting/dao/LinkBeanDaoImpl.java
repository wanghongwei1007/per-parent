package com.kalix.qiao.system.setting.dao;


import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.qiao.system.setting.api.dao.ILinkBeanDao;
import com.kalix.qiao.system.setting.entities.LinkBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class LinkBeanDaoImpl extends GenericDao<LinkBean, Long> implements ILinkBeanDao {
    @Override
    @PersistenceContext(unitName = "qiao-system-setting-unit")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}

