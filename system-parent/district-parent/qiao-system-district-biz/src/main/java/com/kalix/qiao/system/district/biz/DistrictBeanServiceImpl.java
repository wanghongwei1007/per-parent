package com.kalix.qiao.system.district.biz;
/**
 * Created by sunli on 2018/5/13.
 */
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.qiao.system.district.api.biz.IDistrictBeanService;
import com.kalix.qiao.system.district.api.dao.IDistrictBeanDao;
import com.kalix.qiao.system.district.entities.DistrictBean;

public class DistrictBeanServiceImpl extends ShiroGenericBizServiceImpl<IDistrictBeanDao, DistrictBean>
        implements IDistrictBeanService {

    @Override
    public JsonStatus saveEntity(DistrictBean entity) {
        return super.saveEntity(entity);
    }
}
