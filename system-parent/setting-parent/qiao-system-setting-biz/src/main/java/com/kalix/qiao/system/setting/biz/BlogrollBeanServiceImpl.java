package com.kalix.qiao.system.setting.biz;

import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.framework.core.util.Assert;
import com.kalix.qiao.system.setting.api.biz.IBlogrollBeanService;
import com.kalix.qiao.system.setting.api.dao.IBlogrollBeanDao;
import com.kalix.qiao.system.setting.entities.BlogrollBean;
import org.apache.commons.lang.StringUtils;

/**
 * @类描述：
 * @创建人：
 * @创建时间：
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class BlogrollBeanServiceImpl extends ShiroGenericBizServiceImpl<IBlogrollBeanDao, BlogrollBean> implements IBlogrollBeanService {
    @Override
    public void beforeSaveEntity(BlogrollBean entity, JsonStatus status) {
        String userName = shiroService.getCurrentUserRealName();
        Assert.notNull(userName, "用户名不能为空.");
        /*entity.setPublishPeople(userName);*/
        super.beforeSaveEntity(entity, status);
    }
}
