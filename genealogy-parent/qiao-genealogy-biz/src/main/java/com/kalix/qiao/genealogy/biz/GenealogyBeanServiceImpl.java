package com.kalix.qiao.genealogy.biz;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;
import com.kalix.qiao.genealogy.api.biz.IClansmanBeanService;
import com.kalix.qiao.genealogy.api.biz.IGenealogyBeanService;
import com.kalix.qiao.genealogy.api.dao.IGenealogyBeanDao;
import com.kalix.qiao.genealogy.entities.GenealogyBean;
import com.kalix.qiao.genealogy.api.dto.ClansmanDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/5/13.
 */
public class GenealogyBeanServiceImpl extends GenericBizServiceImpl<IGenealogyBeanDao, GenealogyBean> implements IGenealogyBeanService {

    private IClansmanBeanService clansmanBeanService;

    @Override
    public JsonData queryForTree() {
        List<GenealogyBean> genealogyBeanList = dao.getAll();
        List<ClansmanDTO> list = new ArrayList<>();
        JsonData jsonData = new JsonData();
        if (genealogyBeanList.size()>0) {
            for(GenealogyBean g:genealogyBeanList){
                ClansmanDTO j = new ClansmanDTO();
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
        String[] strings = genealogyBean.getGenealogysite().split(",");
        List<String> stringList = Arrays.asList(strings);
        JsonData j = new JsonData();
        j.setData(stringList);
        genealogyBean.setDefaultOption(j);
        List<GenealogyBean> list = new ArrayList<>();
        list.add(genealogyBean);
        JsonData jsonData = new JsonData();
        jsonData.setData(list);
        jsonData.setTotalCount((long) list.size());
        return jsonData;
    }

    @Override
    public JsonData deleteById(long id) {
        dao.remove(id);
        clansmanBeanService.deleteByGenealogyId(id);
        JsonData jsonData = new JsonData();
        return jsonData;
    }

    public void setClansmanBeanService(IClansmanBeanService clansmanBeanService) {
        this.clansmanBeanService = clansmanBeanService;
    }
}
