package com.kalix.qiao.system.setting.biz;

import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.qiao.system.setting.api.biz.ISettingBeanService;
import com.kalix.qiao.system.setting.api.dao.ISettingBeanDao;
import com.kalix.qiao.system.setting.entities.SettingBean;

public class SettingBeanServiceImpl extends ShiroGenericBizServiceImpl<ISettingBeanDao, SettingBean>
        implements ISettingBeanService {

    @Override
    public JsonStatus saveEntity(SettingBean entity) {
        return super.saveEntity(entity);
    }
}
