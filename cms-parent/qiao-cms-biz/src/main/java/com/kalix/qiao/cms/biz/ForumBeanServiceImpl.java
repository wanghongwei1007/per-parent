package com.kalix.qiao.cms.biz;

import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;
import com.kalix.qiao.cms.api.biz.IForumBeanService;
import com.kalix.qiao.cms.api.biz.IReplyBeanService;
import com.kalix.qiao.cms.api.dao.IForumBeanDao;
import com.kalix.qiao.cms.api.dao.IReplyBeanDao;
import com.kalix.qiao.cms.entities.ForumBean;
import com.kalix.qiao.cms.entities.ReplyBean;

/**
 * Created by Administrator on 2018/5/13.
 */
public class ForumBeanServiceImpl extends GenericBizServiceImpl<IForumBeanDao, ForumBean> implements IForumBeanService {
}
