package com.kalix.qiao.system.setting.biz;

import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.qiao.system.setting.api.biz.IQiaoSettingBeanService;
import com.kalix.qiao.system.setting.api.dao.IQiaoSettingBeanDao;
import com.kalix.qiao.system.setting.entities.QiaoSettingBean;

public class LinkBeanServiceImpl extends ShiroGenericBizServiceImpl<IQiaoSettingBeanDao, QiaoSettingBean>
        implements IQiaoSettingBeanService {

    @Override
    public JsonStatus saveEntity(QiaoSettingBean entity) {
        Integer maxValue = dao.getFieldMaxValue("value", "type='" + entity.getType() + "'");

        maxValue = maxValue + 1;

        entity.setValue(maxValue);

        return super.saveEntity(entity);
    }
}
