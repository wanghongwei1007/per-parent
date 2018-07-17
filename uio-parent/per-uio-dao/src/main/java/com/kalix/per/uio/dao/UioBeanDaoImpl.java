package com.kalix.per.uio.dao;

import com.kalix.framework.core.api.dao.IGenericDao;
import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.per.uio.api.dao.IUioBeanDao;
import com.kalix.per.uio.entities.UioBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by sunli on 2018/5/13.
 */
public class UioBeanDaoImpl extends IGenericDao<UioBean, Long> implements IUioBeanDao {
    @PersistenceContext(unitName = "uio-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
