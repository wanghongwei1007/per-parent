package com.kalix.qiao.system.dict.dao;


import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.qiao.system.dict.api.dao.IQiaoDictBeanDao;
import com.kalix.qiao.system.dict.entities.QiaoDictBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class QiaoDictBeanDaoImpl extends GenericDao<QiaoDictBean, Long> implements IQiaoDictBeanDao {
    @Override
    @PersistenceContext(unitName = "qiao-system-dict-unit")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
