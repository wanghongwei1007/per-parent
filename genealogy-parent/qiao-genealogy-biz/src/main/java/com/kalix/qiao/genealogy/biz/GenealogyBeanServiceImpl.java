package com.kalix.qiao.genealogy.biz;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;
import com.kalix.qiao.genealogy.api.biz.IGenealogyBeanService;
import com.kalix.qiao.genealogy.api.dao.IGenealogyBeanDao;
import com.kalix.qiao.genealogy.entities.GenealogyBean;
import com.kalix.qiao.genealogy.api.dto.JsonTreeZsDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/13.
 */
public class GenealogyBeanServiceImpl extends GenericBizServiceImpl<IGenealogyBeanDao, GenealogyBean> implements IGenealogyBeanService {


    @Override
    public JsonData queryForTree() {
        List<GenealogyBean> genealogyBeanList = dao.getAll();
        List<JsonTreeZsDTO> list = new ArrayList<>();
        JsonData jsonData = new JsonData();
        if (genealogyBeanList.size()>0) {
            for(GenealogyBean g:genealogyBeanList){
                JsonTreeZsDTO j = new JsonTreeZsDTO();
                j.setModelId(g.getId());
                j.setLabel(g.getGenealogyname());
                list.add(j);
            }
            jsonData.setData(list);
            jsonData.setTotalCount((long) list.size());
        }else{
            jsonData.setTotalCount((long) list.size());
        }
        return jsonData;
    }

    @Override
    public JsonData findById(long id) {
        GenealogyBean genealogyBean = dao.get(id);
        List<GenealogyBean> list = new ArrayList<>();
        list.add(genealogyBean);
        JsonData jsonData = new JsonData();
        jsonData.setData(list);
        jsonData.setTotalCount((long) list.size());
        return jsonData;
    }

    @Override
    public JsonData deleteById(long id) {

        return null;
    }
}
