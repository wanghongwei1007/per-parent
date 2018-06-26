package com.kalix.qiao.genealogy.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.qiao.genealogy.api.dao.IGenerationBeanDao;
import com.kalix.qiao.genealogy.entities.GenerationBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by wangpeng on 2018/6/15.
 */
public class GenerationBeanDaoImpl extends GenericDao<GenerationBean, Long> implements IGenerationBeanDao {
    @Override
    @PersistenceContext(unitName = "genealogy-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }


    @Override
    @Transactional
    public void DeleteByGenealogyId(long genealogyId) {
        String sql = "delete from qiao_genealogy_generation g where g.genealogyId = '"+genealogyId+"'";
        entityManager.createNativeQuery(sql).executeUpdate();
    }
}
