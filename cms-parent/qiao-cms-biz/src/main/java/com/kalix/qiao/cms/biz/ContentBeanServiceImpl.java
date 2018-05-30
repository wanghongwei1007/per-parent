package com.kalix.qiao.cms.biz;

import com.google.gson.Gson;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;
import com.kalix.qiao.cms.api.biz.IColumnBeanService;
import com.kalix.qiao.cms.api.biz.IContentBeanService;
import com.kalix.qiao.cms.api.biz.IMenuBeanService;
import com.kalix.qiao.cms.api.dao.IContentBeanDao;
import com.kalix.qiao.cms.api.dto.CascaderDTO;
import com.kalix.qiao.cms.api.dto.JsonTreeDTO;
import com.kalix.qiao.cms.entities.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/13.
 */
public class ContentBeanServiceImpl extends GenericBizServiceImpl<IContentBeanDao, ContentBean> implements IContentBeanService {

    private IColumnBeanService columnBeanService;
    private IMenuBeanService menuBeanService;

    /**
     *栏目菜单级联查询
     * @return
     */
    @Override
    public JsonData getMenuByColumnId() {
        List<ColumnBean> columnList = columnBeanService.getAllEntity();
        Gson gson = new Gson();
        List<CascaderDTO> list = new ArrayList<>();
        for (ColumnBean columnBean : columnList) {
            CascaderDTO cascaderDTO = new CascaderDTO();
            cascaderDTO.setValue(String.valueOf(columnBean.getId()));
            cascaderDTO.setLabel(columnBean.getName());
            List<MenuBean> menuBeanList = dao.getMenuByColumnId(columnBean.getId());
            List children = new ArrayList();
            if (menuBeanList.size() > 0) {
                for (MenuBean menuBean : menuBeanList) {
                    CascaderDTO json = new CascaderDTO();
                    json.setValue(String.valueOf(menuBean.getId()));
                    json.setLabel(menuBean.getName());
                    children.add(json);
                }
            }
            cascaderDTO.setChildren(children);
            list.add(cascaderDTO);
        }
        String str = gson.toJson(list);
        JsonData jsonData = new JsonData();
        List<String> strList = new ArrayList<>();
        strList.add(str);
        jsonData.setTotalCount((long) list.size());
        jsonData.setData(strList);
        return jsonData;
    }

    /**
     * 内容管理树形列表参数
     * @return
     */
    @Override
    public JsonData getTreeInfo() {
        List<JsonTreeDTO> list = new ArrayList<>();
        List<ColumnBean> columnList = columnBeanService.getAllEntity();
        for (ColumnBean column : columnList) {
            JsonTreeDTO jsonTreeDTO = new JsonTreeDTO();
            jsonTreeDTO.setLabel(column.getName());
            jsonTreeDTO.setModelId(column.getId());
            jsonTreeDTO.setFlag("column");
            List<MenuBean> menuBeanList = dao.getMenuByColumnId(column.getId());
            if (menuBeanList.size()>0) {
                List children = new ArrayList();
                for (MenuBean menuBean:menuBeanList) {
                    JsonTreeDTO jsonTreeDTO1 = new JsonTreeDTO();
                    jsonTreeDTO1.setLabel(menuBean.getName());
                    jsonTreeDTO1.setModelId(menuBean.getId());
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

    /**
     * 查询内容列表
     * @param menuId 所属菜单ID
     * @return
     */
    @Override
    public JsonData getContentByMenuId(long menuId) {
        List<ContentBean> list = dao.find("select c from ContentBean c where c.menuId=?1", menuId);
        JsonData jsonData = new JsonData();
        jsonData.setTotalCount((long) list.size());
        jsonData.setData(list);
        return jsonData;
    }

    public void setColumnBeanService(IColumnBeanService columnBeanService) {
        this.columnBeanService = columnBeanService;
    }

    public void setMenuBeanService(IMenuBeanService menuBeanService) {
        this.menuBeanService = menuBeanService;
    }
}
