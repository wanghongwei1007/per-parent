package com.kalix.qiao.cms.biz;

import com.google.gson.Gson;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;
import com.kalix.qiao.cms.api.biz.IColumnBeanService;
import com.kalix.qiao.cms.api.biz.IContentBeanService;
import com.kalix.qiao.cms.api.biz.IMenuBeanService;
import com.kalix.qiao.cms.api.dao.IContentBeanDao;
import com.kalix.qiao.cms.entities.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/13.
 */
public class ContentBeanServiceImpl extends GenericBizServiceImpl<IContentBeanDao, ContentBean> implements IContentBeanService {

    private IColumnBeanService columnBeanService;

    /**
     *栏目菜单级联查询
     * @return
     */
    @Override
    public JsonData getMenuByColumnId() {
        List<ColumnBean> columnList = columnBeanService.getAllEntity();
        Gson gson = new Gson();
        List<JsonClassBean> list = new ArrayList<>();
        for (ColumnBean columnBean : columnList) {
            JsonClassBean jsonClassBean = new JsonClassBean();
            jsonClassBean.setValue(String.valueOf(columnBean.getId()));
            jsonClassBean.setLabel(columnBean.getName());
            List<MenuBean> menuBeanList = dao.getMenuByColumnId(columnBean.getId());
            List children = new ArrayList();
            if (menuBeanList.size() > 0) {
                for (MenuBean menuBean : menuBeanList) {
                    JsonClassBean json = new JsonClassBean();
                    json.setValue(String.valueOf(menuBean.getId()));
                    json.setLabel(menuBean.getName());
                    children.add(json);
                }
            }
            jsonClassBean.setChildren(children);
            list.add(jsonClassBean);
        }
        String str = gson.toJson(list);
        JsonData jsonData = new JsonData();
        List<String> strList = new ArrayList<>();
        strList.add(str);
        jsonData.setData(strList);
        return jsonData;
    }

    /**
     * 内容管理树形列表参数
     * @return
     */
    @Override
    public JsonData getTreeInfo() {
        Gson gson = new Gson();
        List<JsonTreeBean> list = new ArrayList<>();
        List<ColumnBean> columnList = columnBeanService.getAllEntity();
        for (ColumnBean column : columnList) {
            JsonTreeBean jsonTreeBean = new JsonTreeBean();
            String string = gson.toJson(column);
            jsonTreeBean.setLabel(string);
            List<MenuBean> menuBeanList = dao.getMenuByColumnId(column.getId());
            if (menuBeanList.size()>0) {
                List children = new ArrayList();
                for (MenuBean menuBean:menuBeanList) {
                    JsonTreeBean jsonTreeBean1 = new JsonTreeBean();
                    String str = gson.toJson(menuBean);
                    jsonTreeBean1.setLabel(str);
                    children.add(jsonTreeBean1);
                }
                jsonTreeBean.setChildren(children);
            }
            list.add(jsonTreeBean);
        }
        JsonData jsonData = new JsonData();
        jsonData.setData(list);
        return jsonData;
    }

    public void setColumnBeanService(IColumnBeanService columnBeanService) {
        this.columnBeanService = columnBeanService;
    }
}
