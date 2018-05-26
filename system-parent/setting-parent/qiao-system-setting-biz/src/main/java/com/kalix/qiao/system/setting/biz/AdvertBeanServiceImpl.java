package com.kalix.qiao.system.setting.biz;
/**
 * Created by sunli on 2018/5/13.
 */
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.framework.core.util.Assert;
import com.kalix.qiao.system.setting.api.biz.IAdvertBeanService;
import com.kalix.qiao.system.setting.api.dao.IAdvertBeanDao;
import com.kalix.qiao.system.setting.entities.AdvertBean;

public class AdvertBeanServiceImpl extends ShiroGenericBizServiceImpl<IAdvertBeanDao, AdvertBean> implements IAdvertBeanService {
    @Override
    public void beforeSaveEntity(AdvertBean entity, JsonStatus status) {
        String userName = shiroService.getCurrentUserRealName();
        Assert.notNull(userName, "用户名不能为空.");
        super.beforeSaveEntity(entity, status);
    }
}
