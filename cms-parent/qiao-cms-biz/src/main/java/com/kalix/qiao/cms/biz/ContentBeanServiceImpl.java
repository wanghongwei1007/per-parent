package com.kalix.qiao.cms.biz;

import com.google.gson.Gson;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;
import com.kalix.qiao.cms.api.biz.IColumnBeanService;
import com.kalix.qiao.cms.api.biz.IContentBeanService;
import com.kalix.qiao.cms.api.biz.IMenuBeanService;
import com.kalix.qiao.cms.api.dao.IContentBeanDao;
import com.kalix.qiao.cms.entities.ColumnBean;
import com.kalix.qiao.cms.entities.ContentBean;
import com.kalix.qiao.cms.entities.JsonClassBean;
import com.kalix.qiao.cms.entities.MenuBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/13.
 */
public class ContentBeanServiceImpl extends GenericBizServiceImpl<IContentBeanDao, ContentBean> implements IContentBeanService {

    private IColumnBeanService columnBeanService;

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

    public void setColumnBeanService(IColumnBeanService columnBeanService) {
        this.columnBeanService = columnBeanService;
    }
}
