package com.kalix.qiao.system.setting.dao;


import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.qiao.system.setting.api.dao.IQiaoSettingBeanDao;
import com.kalix.qiao.system.setting.entities.QiaoSettingBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class QiaoSettingBeanDaoImpl extends GenericDao<QiaoSettingBean, Long> implements IQiaoSettingBeanDao {
    @Override
    @PersistenceContext(unitName = "qiao-system-setting-unit")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}

