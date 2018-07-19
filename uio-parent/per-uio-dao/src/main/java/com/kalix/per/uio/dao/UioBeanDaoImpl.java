package com.kalix.per.uio.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.per.uio.api.dao.IUioBeanDao;
import com.kalix.per.uio.entities.UioBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UioBeanDaoImpl extends GenericDao<UioBean, Long> implements IUioBeanDao {
    @PersistenceContext(unitName = "uio-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
