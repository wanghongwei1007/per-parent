package com.kalix.qiao.cms.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.qiao.cms.entities.MenuBean;
import com.kalix.qiao.cms.api.dao.IMenuBeanDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Administrator on 2018/5/13.
 */
public class MenuBeanDaoImpl extends GenericDao<MenuBean, Long> implements IMenuBeanDao {
    @Override
    @PersistenceContext(unitName = "cms-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
