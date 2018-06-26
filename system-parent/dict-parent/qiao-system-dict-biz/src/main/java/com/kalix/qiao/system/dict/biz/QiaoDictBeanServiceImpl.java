package com.kalix.qiao.system.dict.biz;

import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.impl.system.BaseDictServiceImpl;
import com.kalix.qiao.system.dict.api.biz.IQiaoDictBeanService;
import com.kalix.qiao.system.dict.api.dao.IQiaoDictBeanDao;
import com.kalix.qiao.system.dict.entities.QiaoDictBean;

import java.io.UnsupportedEncodingException;
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
    public List getLabelByType(String type) {
        return dao.find("select d from QiaoDictBean d where d.type=?1 order by d.value", type);
    }
}
