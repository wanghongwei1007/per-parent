package com.kalix.qiao.system.setting.dao;


import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.qiao.system.setting.api.dao.IBlogrollBeanDao;
import com.kalix.qiao.system.setting.entities.BlogrollBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BlogrollBeanDaoImpl extends GenericDao<BlogrollBean, Long> implements IBlogrollBeanDao {
    @Override
    @PersistenceContext(unitName = "setting-unit")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}

