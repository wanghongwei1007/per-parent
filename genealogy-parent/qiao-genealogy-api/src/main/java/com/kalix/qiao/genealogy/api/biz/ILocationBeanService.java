package com.kalix.qiao.genealogy.api.biz;

import com.kalix.framework.core.api.biz.IBizService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.qiao.genealogy.entities.LocationBean;

/**
 * Created by wangpeng on 2018/7/3.
 */
public interface ILocationBeanService extends IBizService<LocationBean> {

    JsonData getLocationByGenealogyId(long jsonStr, int page, int limit);

    String deleteById(long id);

    JsonData getLocationForMap(long genealogyId);
}
