package com.kalix.qiao.forum.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.qiao.forum.api.dao.IReplyBeanDao;
import com.kalix.qiao.forum.entities.ReplyBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by sunli on 2018/5/13.
 */
public class ReplyBeanDaoImpl extends GenericDao<ReplyBean, Long> implements IReplyBeanDao {
    @Override
    @PersistenceContext(unitName = "forum-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }

    @Override
    public List<ReplyBean> findByParentId(Integer parentId) {
        return (List<ReplyBean>) this.find("select rb from ReplyBean rb where rb.parentId = ?1 order by rb.id", parentId);
    }

    @Override
    public List<ReplyBean> findListByPostId(long postId) {
        return null;
    }

    @Override
    public void deleteAllByPostid(long id) {
        String sql = "delete from qiao_forum_reply r where r.postid='"+id+"'";
        entityManager.createNativeQuery(sql).executeUpdate();
    }


}
