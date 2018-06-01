package com.kalix.qiao.forum.api.dao;

import com.kalix.framework.core.api.dao.IGenericDao;
import com.kalix.qiao.forum.entities.ReplyBean;

import java.util.List;

/**
 * Created by sunli on 2018/5/13.
 */
public interface IReplyBeanDao extends IGenericDao<ReplyBean, Long> {

    List<ReplyBean> findByParentId(Integer parentId);

    List<ReplyBean> findListByPostId(long postId);

}
