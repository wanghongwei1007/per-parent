package com.kalix.qiao.genealogy.biz;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;
import com.kalix.qiao.genealogy.api.biz.IGenerationBeanService;
import com.kalix.qiao.genealogy.api.dao.IGenerationBeanDao;
import com.kalix.qiao.genealogy.api.dto.SelectDTO;
import com.kalix.qiao.genealogy.entities.GenerationBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangpeng on 2018/6/22.
 */
public class GenerationServiceImpl extends GenericBizServiceImpl<IGenerationBeanDao, GenerationBean> implements IGenerationBeanService {


    @Override
    public JsonData getGenerationByGenealogyId(long genealogyId) {
        List<GenerationBean> generationBeanList = dao.find("select g from GenerationBean g where g.genealogyId = ?1", genealogyId);
        JsonData jsonData = new JsonData();
        jsonData.setTotalCount((long) generationBeanList.size());
        jsonData.setData(generationBeanList);
        return jsonData;
    }

    @Override
    public JsonData getGenerationForSelect(long genealogyId) {
        List<GenerationBean> generationBeanList = dao.find("select g from GenerationBean g where g.genealogyId = ?1", genealogyId);
        List<SelectDTO> selectDTOList = new ArrayList<>();
        if (generationBeanList.size() > 0) {
            String str = generationBeanList.get(0).getGrade();
            for (int i=0;i<str.length();i++) {
                SelectDTO selectDTO = new SelectDTO();
                selectDTO.setLabel(String.valueOf(str.charAt(i)));
                selectDTO.setValue(String.valueOf(str.charAt(i)));
                selectDTOList.add(selectDTO);
            }
        }
        JsonData jsonData = new JsonData();
        jsonData.setTotalCount((long) selectDTOList.size());
        jsonData.setData(selectDTOList);
        return jsonData;
    }

    @Override
    public void DeleteByGenealogyId(long genealogyId) {
        dao.DeleteByGenealogyId(genealogyId);
    }
}
