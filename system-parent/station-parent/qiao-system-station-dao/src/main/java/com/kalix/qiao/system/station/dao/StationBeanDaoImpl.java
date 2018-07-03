package com.kalix.qiao.system.station.dao;
/**
 * Created by sunli on 2018/7/3.
 */

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.qiao.system.station.api.dao.IStationBeanDao;
import com.kalix.qiao.system.station.entities.StationBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class StationBeanDaoImpl extends GenericDao<StationBean, Long> implements IStationBeanDao {
    @Override
    @PersistenceContext(unitName = "qiao-system-station-unit")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
