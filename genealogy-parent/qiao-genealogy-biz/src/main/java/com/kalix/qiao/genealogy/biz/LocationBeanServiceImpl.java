package com.kalix.qiao.genealogy.biz;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;
import com.kalix.qiao.genealogy.api.biz.ILocationBeanService;
import com.kalix.qiao.genealogy.api.dao.ILocationBeanDao;
import com.kalix.qiao.genealogy.api.dto.MapDTO;
import com.kalix.qiao.genealogy.entities.LocationBean;

import java.util.ArrayList;
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
    public String deleteById(long id) {
        dao.remove(id);
        return "删除成功";
    }

    /**
     * 迁徙地图数据封装
     * @param genealogyId 家谱ID
     * @return
     */
    @Override
    public JsonData getLocationForMap(long genealogyId) {
        List<LocationBean> locationBeans = dao.find("select l from LocationBean l where l.genealogyId = ?1", genealogyId);
        List<MapDTO> list = new ArrayList<>();
        for (LocationBean l:locationBeans) {
            MapDTO mapDTO = new MapDTO();
            mapDTO.setFromCoord(l.getStartCity());
            mapDTO.setToCoord(l.getEndCity());
            list.add(mapDTO);
        }
        JsonData jsonData = new JsonData();
        jsonData.setTotalCount((long) list.size());
        jsonData.setData(list);
        return jsonData;
    }
}
