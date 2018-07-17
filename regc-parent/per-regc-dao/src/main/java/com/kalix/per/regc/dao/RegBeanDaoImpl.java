package com.kalix.per.regc.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.per.regc.api.dao.IRegBeanDao;
import com.kalix.per.regc.entities.RegBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by sunli on 2018/5/13.
 */
public class RegBeanDaoImpl extends GenericDao<RegBean, Long> implements IRegBeanDao {
    @PersistenceContext(unitName = "regc-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
