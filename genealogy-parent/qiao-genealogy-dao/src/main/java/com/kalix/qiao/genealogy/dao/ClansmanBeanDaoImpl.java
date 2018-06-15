package com.kalix.qiao.genealogy.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.qiao.genealogy.api.dao.IClansmanBeanDao;
import com.kalix.qiao.genealogy.entities.ClansmanBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by wangpeng on 2018/6/15.
 */
public class ClansmanBeanDaoImpl extends GenericDao<ClansmanBean, Long> implements IClansmanBeanDao {
    @Override
    @PersistenceContext(unitName = "genealogy-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }

    @Override
    @Transactional
    public void deleteByGenealogyId(long id) {
        String sql = "delete from qiao_genealogy_clansman c where c.genealogynameid='"+id+"'";
        entityManager.createNativeQuery(sql).executeUpdate();
    }
}
