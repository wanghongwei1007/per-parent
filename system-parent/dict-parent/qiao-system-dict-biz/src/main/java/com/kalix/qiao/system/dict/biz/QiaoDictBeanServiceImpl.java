package com.kalix.qiao.system.dict.biz;

import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.impl.system.BaseDictServiceImpl;
import com.kalix.qiao.system.dict.api.biz.IQiaoDictBeanService;
import com.kalix.qiao.system.dict.api.dao.IQiaoDictBeanDao;
import com.kalix.qiao.system.dict.entities.QiaoDictBean;

import java.util.List;

public class QiaoDictBeanServiceImpl extends BaseDictServiceImpl<IQiaoDictBeanDao, QiaoDictBean>
        implements IQiaoDictBeanService {

    @Override
    public JsonStatus saveEntity(QiaoDictBean entity) {
        Integer maxValue = dao.getFieldMaxValue("value","type='"+entity.getType()+"'");

        maxValue=maxValue+1;
        entity.setValue(maxValue);

        return super.saveEntity(entity);
    }

    @Override
    public List getLabelByType() {
        return dao.find("select d from QiaoDictBean d where d.type='类型标识'");
    }
}
