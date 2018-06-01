package com.kalix.qiao.forum.api.biz;

import com.kalix.framework.core.api.biz.IBizService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.qiao.forum.entities.ForumBean;

/**
 * Created by sunli on 2018/5/13.
 */
public interface IForumBeanService extends IBizService<ForumBean> {
    JsonData getReplyForTree();
}
