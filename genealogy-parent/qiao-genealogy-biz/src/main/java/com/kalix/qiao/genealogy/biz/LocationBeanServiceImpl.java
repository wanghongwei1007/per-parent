package com.kalix.qiao.genealogy.biz;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;
import com.kalix.qiao.genealogy.api.biz.ILocationBeanService;
import com.kalix.qiao.genealogy.api.dao.ILocationBeanDao;
import com.kalix.qiao.genealogy.entities.LocationBean;

import java.util.List;


/**
 * Created by wangpeng on 2018/7/3
 */
public class LocationBeanServiceImpl extends GenericBizServiceImpl<ILocationBeanDao, LocationBean> implements ILocationBeanService {

    @Override
    public JsonData getLocationByGenealogyId(long jsonStr, int page, int limit) {
        List<LocationBean> locationBeans = dao.find("select l from LocationBean l where l.genealogyId = ?1 order by l.updateDate desc", jsonStr);
        List<LocationBean> list = locationBeans.subList(page*limit-limit, limit*page>locationBeans.size()?locationBeans.size():limit*page);
        JsonData jsonData = new JsonData();
        jsonData.setData(list);
        jsonData.setTotalCount((long) locationBeans.size());
        return jsonData;
    }

    @Override
    public void deleteById(long id) {
        dao.remove(id);
    }
}
