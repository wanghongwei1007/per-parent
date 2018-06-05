package com.kalix.qiao.genealogy.biz;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;
import com.kalix.qiao.genealogy.api.biz.IGenealogyBeanService;
import com.kalix.qiao.genealogy.api.dao.IGenealogyBeanDao;
import com.kalix.qiao.genealogy.entities.GenealogyBean;

/**
 * Created by Administrator on 2018/5/13.
 */
public class GenealogyBeanServiceImpl extends GenericBizServiceImpl<IGenealogyBeanDao, GenealogyBean> implements IGenealogyBeanService {
    private IGenealogyBeanService genealogyBeanService;
    private IClansmanBeanService clansmanBeanService;

    @Override
    public JsonData getTreeInfo() {
        List<JsonTreeDTO> list = new ArrayList<>();
        List<ColumnBean> columnList = columnBeanService.getAllEntity();
        int i = 0;
        for (ColumnBean column : columnList) {
            JsonTreeDTO jsonTreeDTO = new JsonTreeDTO();
            jsonTreeDTO.setLabel(column.getName());
            if (i > 0) {
                jsonTreeDTO.setModelId(column.getId());
                jsonTreeDTO.setFlag("column");
            }
            List<MenuBean> menuBeanList = dao.getMenuByColumnId(column.getId());
            if (menuBeanList.size() > 0) {
                List children = new ArrayList();
                for (MenuBean menuBean : menuBeanList) {
                    JsonTreeDTO jsonTreeDTO1 = new JsonTreeDTO();
                    jsonTreeDTO1.setLabel(menuBean.getName());
                    jsonTreeDTO1.setModelId(menuBean.getId());
                    if (i == 0) {
                        jsonTreeDTO.setModelId(menuBean.getId());
                        jsonTreeDTO.setFlag("columnMenu");
                        i++;
                    }
                    jsonTreeDTO1.setFlag("menu");
                    children.add(jsonTreeDTO1);
                }
                jsonTreeDTO.setChildren(children);
            }
            list.add(jsonTreeDTO);
        }
        JsonData jsonData = new JsonData();
        jsonData.setTotalCount((long) list.size());
        jsonData.setData(list);
        return jsonData;
    }
}
