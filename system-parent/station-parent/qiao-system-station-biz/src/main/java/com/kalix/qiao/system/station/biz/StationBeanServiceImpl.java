package com.kalix.qiao.system.station.biz;
/**
 * Created by sunli on 2018/7/3.
 */

import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.qiao.system.station.api.biz.IStationBeanService;
import com.kalix.qiao.system.station.api.dao.IStationBeanDao;
import com.kalix.qiao.system.station.entities.StationBean;


public class StationBeanServiceImpl extends ShiroGenericBizServiceImpl<IStationBeanDao, StationBean>
        implements IStationBeanService {

}
