package com.kalix.qiao.genealogy.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.qiao.genealogy.api.dao.ILocationBeanDao;
import com.kalix.qiao.genealogy.entities.LocationBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by wangpeng on 2018/7/3
 */
public class LocationBeanDaoImpl extends GenericDao<LocationBean, Long> implements ILocationBeanDao {
    @Override
    @PersistenceContext(unitName = "genealogy-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }


}
