package com.kalix.qiao.system.dict.biz;

import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.impl.system.BaseDictServiceImpl;
import com.kalix.qiao.system.dict.api.biz.IQiaoDictBeanService;
import com.kalix.qiao.system.dict.api.dao.IQiaoDictBeanDao;
import com.kalix.qiao.system.dict.entities.QiaoDictBean;

public class QiaoDictBeanServiceImpl extends BaseDictServiceImpl<IQiaoDictBeanDao, QiaoDictBean>
        implements IQiaoDictBeanService {

    @Override
    public JsonStatus saveEntity(QiaoDictBean entity) {
        Integer maxValue = dao.getFieldMaxValue("value", "type='" + entity.getType() + "'");
        maxValue = maxValue + 1;
        return super.saveEntity(entity);
    }
}
