package com.kalix.qiao.system.setting.dao;
/**
 * Created by sunli on 2018/5/13.
 */

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

