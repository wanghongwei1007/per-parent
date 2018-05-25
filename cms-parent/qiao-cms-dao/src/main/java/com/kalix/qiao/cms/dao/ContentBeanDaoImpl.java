package com.kalix.qiao.cms.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.qiao.cms.api.dao.IContentBeanDao;
import com.kalix.qiao.cms.api.dao.IMenuBeanDao;
import com.kalix.qiao.cms.entities.ContentBean;
import com.kalix.qiao.cms.entities.MenuBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Administrator on 2018/5/13.
 */
public class ContentBeanDaoImpl extends GenericDao<ContentBean, Long> implements IContentBeanDao {

    private IMenuBeanDao menuBeanDao;

    @Override
    @PersistenceContext(unitName = "cms-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }

    @Override
    public List<MenuBean> getColumnAndMenu(long navid) {
        List<MenuBean> list = menuBeanDao.find("select m.id,m.name from MenuBean m where m.navid=?1", navid);
        return list;
//        return entityManager.createQuery("select m.id,m.name from MenuBean m where m.navid=" + navid + "", MenuBean.class).getResultList();
    }

    public void setMenuBeanDao(IMenuBeanDao menuBeanDao) {
        this.menuBeanDao = menuBeanDao;
    }
}
