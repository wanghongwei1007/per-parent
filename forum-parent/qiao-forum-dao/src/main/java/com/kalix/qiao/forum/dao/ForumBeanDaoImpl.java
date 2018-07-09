package com.kalix.qiao.forum.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.qiao.forum.api.dao.IForumBeanDao;
import com.kalix.qiao.forum.entities.ForumBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by sunli on 2018/5/13.
 */
public class ForumBeanDaoImpl extends GenericDao<ForumBean, Long> implements IForumBeanDao {
    @Override
    @PersistenceContext(unitName = "forum-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }

}
