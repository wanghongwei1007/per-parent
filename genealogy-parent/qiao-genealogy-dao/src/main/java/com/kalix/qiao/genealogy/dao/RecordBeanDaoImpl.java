package com.kalix.qiao.genealogy.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.qiao.genealogy.api.dao.IRecordBeanDao;
import com.kalix.qiao.genealogy.entities.RecordBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by wangpeng on 2018/6/15.
 */
public class RecordBeanDaoImpl extends GenericDao<RecordBean, Long> implements IRecordBeanDao {
    @Override
    @PersistenceContext(unitName = "genealogy-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }


}
