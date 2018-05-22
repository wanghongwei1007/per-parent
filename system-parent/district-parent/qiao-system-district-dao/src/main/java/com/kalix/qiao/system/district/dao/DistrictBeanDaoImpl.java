package com.kalix.qiao.system.district.dao;


import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.qiao.system.district.api.dao.IDistrictBeanDao;
import com.kalix.qiao.system.district.entities.DistrictBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DistrictBeanDaoImpl extends GenericDao<DistrictBean, Long> implements IDistrictBeanDao {
    @Override
    @PersistenceContext(unitName = "qiao-system-district-unit")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
