package com.kalix.qiao.forum.api.biz;

import com.kalix.framework.core.api.biz.IBizService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.qiao.forum.entities.ReplyBean;
import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by sunli on 2018/5/13.
 */
public interface IReplyBeanService extends IBizService<ReplyBean> {

    JsonData getReplyByPostId(long postId);

}
