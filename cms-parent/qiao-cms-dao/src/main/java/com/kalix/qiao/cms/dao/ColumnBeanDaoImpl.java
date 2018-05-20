package com.kalix.qiao.cms.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.qiao.cms.api.dao.IColumnBeanDao;
import com.kalix.qiao.cms.entities.ColumnBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Administrator on 2018/5/13.
 */
public class ColumnBeanDaoImpl extends GenericDao<ColumnBean, Long> implements IColumnBeanDao {
    @Override
    @PersistenceContext(unitName = "cms-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
