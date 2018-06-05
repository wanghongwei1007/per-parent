package com.kalix.qiao.genealogy.biz;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;
import com.kalix.qiao.genealogy.api.biz.IClansmanBeanService;
import com.kalix.qiao.genealogy.api.biz.IGenealogyBeanService;
import com.kalix.qiao.genealogy.api.dao.IGenealogyBeanDao;
import com.kalix.qiao.genealogy.api.dto.JsonTreeZsDTO;
import com.kalix.qiao.genealogy.entities.ClansmanBean;
import com.kalix.qiao.genealogy.entities.GenealogyBean;
import org.apache.commons.collections.iterators.ArrayListIterator;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/13.
 */
public class GenealogyBeanServiceImpl extends GenericBizServiceImpl<IGenealogyBeanDao, GenealogyBean> implements IGenealogyBeanService {
    private IGenealogyBeanService genealogyBeanService;
    private IClansmanBeanService clansmanBeanService;

    public void setGenealogyBeanService(IGenealogyBeanService genealogyBeanService) {
        this.genealogyBeanService = genealogyBeanService;
    }

    public void setClansmanBeanService(IClansmanBeanService clansmanBeanService) {
        this.clansmanBeanService = clansmanBeanService;
    }

    @Override
    public JsonData getGenealogyByGeneId() {
        return null;
    }

    /**
     * 家谱录入树形列表参数

     *
     * @return
     */
    @Override
    public JsonData getTree() {
        List<JsonTreeZsDTO> list = new ArrayList<>();
        List<GenealogyBean> genealogyList = genealogyBeanService.getAllEntity();
        int i = 0;
        for (GenealogyBean genealogy : genealogyList) {
            JsonTreeZsDTO jsonTreeZsDTO = new JsonTreeZsDTO();
            jsonTreeZsDTO.setLabel(genealogy.getGenealogyname());
            if (i > 0) {
                jsonTreeZsDTO.setModelId(genealogy.getId());
                jsonTreeZsDTO.setFlag("genealogy");
            }
            List<ClansmanBean> ClansmanBeanList = dao.getClansmanByClansId(genealogy.getId());
            if (ClansmanBeanList.size() > 0) {
                List children = new ArrayList();
                for (ClansmanBean clansmanBean : ClansmanBeanList) {
                    JsonTreeZsDTO jsonTreeDTO = new JsonTreeZsDTO();
//                    jsonTreeDTO.setLabel(ClansmanBean.getName());
//                    jsonTreeDTO.setModelId(ClansmanBean.getId());
                    if (i == 0) {
//                        jsonTreeDTO.setModelId(ClansmanBean.getId());
                        jsonTreeDTO.setFlag("genealogyClansman");
                        i++;
                    }
                    jsonTreeDTO.setFlag("clansman");
                    children.add(jsonTreeDTO);
                }
                jsonTreeZsDTO.setChildren(children);
            }
            list.add(jsonTreeZsDTO);
        }
        JsonData jsonData = new JsonData();
        jsonData.setTotalCount((long) list.size());
        jsonData.setData(list);
        return jsonData;
    }

    @Override
    public JsonData getClansmanByClansId(long clansId) {
        return null;
    }


}
