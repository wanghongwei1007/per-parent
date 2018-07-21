package com.kalix.per.uio.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.per.uio.api.dao.ITesBeanDao;
import com.kalix.per.uio.entities.TesBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 考试持久层实现类
 */
public class TesBeanDaoImpl extends GenericDao<TesBean, Long> implements ITesBeanDao {

    /**
     * 曾删改查继承封装类
     * @param em
     */
    @PersistenceContext(unitName = "uio-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
