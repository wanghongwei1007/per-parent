package com.kalix.qiao.genealogy.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.qiao.genealogy.api.dao.IGenealogyBeanDao;
import com.kalix.qiao.genealogy.entities.GenealogyBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Administrator on 2018/5/13.
 */
public class GenealogyBeanDaoImpl extends GenericDao<GenealogyBean, Long> implements IGenealogyBeanDao {
    @Override
    @PersistenceContext(unitName = "genealogy-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
