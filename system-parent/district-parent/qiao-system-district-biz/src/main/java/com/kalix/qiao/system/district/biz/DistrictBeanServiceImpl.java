package com.kalix.qiao.system.district.biz;
/**
 * Created by sunli on 2018/5/13.
 */

import com.google.gson.Gson;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.qiao.system.district.api.biz.IDistrictBeanService;
import com.kalix.qiao.system.district.api.dao.IDistrictBeanDao;
import com.kalix.qiao.system.district.api.dto.CascaderDTO;
import com.kalix.qiao.system.district.entities.DistrictBean;

import java.util.ArrayList;
import java.util.List;

public class DistrictBeanServiceImpl extends ShiroGenericBizServiceImpl<IDistrictBeanDao, DistrictBean>
        implements IDistrictBeanService {


    /**
     * wangpeng 18-6-1 省市区三级联动
     * @return
     */
    @Override
    public JsonData getDistrictForCascader() {
        CascaderDTO cascaderDTO = new CascaderDTO();
        List<CascaderDTO> list = new ArrayList<>();
        List<DistrictBean> oneList = dao.find("select d from DistrictBean d where d.parentencoding = '0'");
        for (DistrictBean one : oneList) {
            CascaderDTO oneModel = new CascaderDTO();
            oneModel.setValue(one.getBewrite());
            oneModel.setLabel(one.getBewrite());
            List<DistrictBean> twoList = dao.find("select d from DistrictBean d where d.parentencoding = ?1" , one.getCoding());
            List<CascaderDTO> tsList = new ArrayList<>();
            for (DistrictBean two:twoList) {
                CascaderDTO twoModel = new CascaderDTO();
                twoModel.setValue(two.getBewrite());
                twoModel.setLabel(two.getBewrite());
                List<DistrictBean> threeList = dao.find("select d from DistrictBean d where d.parentencoding = ?1" , two.getCoding());
                List<CascaderDTO> thList = new ArrayList<>();
                for (DistrictBean three:threeList) {
                    CascaderDTO threeModel = new CascaderDTO();
                    threeModel.setValue(three.getBewrite());
                    threeModel.setLabel(three.getBewrite());
                    thList.add(threeModel);
                }
                twoModel.setChildren(thList);
                tsList.add(twoModel);
            }
            oneModel.setChildren(tsList);
            list.add(oneModel);
        }
        List<String> infoList = new ArrayList<>();
        infoList.add(new Gson().toJson(list));
        JsonData jsonData = new JsonData();
        jsonData.setTotalCount((long) list.size());
        jsonData.setData(infoList);
        return jsonData;
    }

    @Override
    public JsonData getDistrictForLocation() {
        CascaderDTO cascaderDTO = new CascaderDTO();
        List<CascaderDTO> list = new ArrayList<>();
        List<DistrictBean> oneList = dao.find("select d from DistrictBean d where d.parentencoding = '0'");
        for (DistrictBean one : oneList) {
            CascaderDTO oneModel = new CascaderDTO();
            oneModel.setValue(one.getBewrite());
            oneModel.setLabel(one.getBewrite());
            List<DistrictBean> twoList = dao.find("select d from DistrictBean d where d.parentencoding = ?1" , one.getCoding());
            List<CascaderDTO> tsList = new ArrayList<>();
            for (DistrictBean two:twoList) {
                CascaderDTO twoModel = new CascaderDTO();
                twoModel.setValue(two.getBewrite());
                twoModel.setLabel(two.getBewrite());
                tsList.add(twoModel);
            }
            oneModel.setChildren(tsList);
            list.add(oneModel);
        }
        List<String> infoList = new ArrayList<>();
        infoList.add(new Gson().toJson(list));
        JsonData jsonData = new JsonData();
        jsonData.setTotalCount((long) list.size());
        jsonData.setData(infoList);
        return jsonData;
    }

    @Override
    public JsonStatus saveEntity(DistrictBean entity) {
        return super.saveEntity(entity);
    }


}
