package com.kalix.qiao.cms.biz;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;
import com.kalix.qiao.cms.api.biz.IColumnBeanService;
import com.kalix.qiao.cms.api.biz.IContentBeanService;
import com.kalix.qiao.cms.api.biz.IMenuBeanService;
import com.kalix.qiao.cms.api.dao.IContentBeanDao;
import com.kalix.qiao.cms.entities.ColumnBean;
import com.kalix.qiao.cms.entities.ContentBean;
import com.kalix.qiao.cms.entities.MenuBean;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/13.
 */
public class ContentBeanServiceImpl extends GenericBizServiceImpl<IContentBeanDao, ContentBean> implements IContentBeanService {

    private IColumnBeanService columnBeanService;
    private IMenuBeanService menuBeanService;

    @Override
    public JsonData getColumnAndMenu() {
        List<ColumnBean> columnList = columnBeanService.getAllEntity();
        List<MenuBean> menuList = menuBeanService.getAllEntity();
        String str = "[";
        for (int i = 0; i < columnList.size(); i++) {
            ColumnBean column = columnList.get(i);
            str += "{value: '" + column.getId() + "',label: '" + column.getName() + "'";
            List<MenuBean> menuBeanList = new ArrayList<>();
            for (MenuBean menuBean : menuList) {
                if (column.getId() == menuBean.getNavid()) {
                    menuBeanList.add(menuBean);
                }
            }
            if (menuBeanList.size() > 0) {
                str += ",children: [";
                for (int k = 0; k < menuBeanList.size(); k++) {
                    MenuBean menu = menuList.get(k);
                    str += "{value: '" + menu.getId() + "',label: '" + menu.getName() + "'}";
                    if (k != menuBeanList.size() - 1) {
                        str += ",";
                    }
                }
                str += "]";
            }
            str += "}";
            if (i != columnList.size() - 1) {
                str += ",";
            }
        }
        str += "]";
        JsonData jsonData = new JsonData();
        List<String> list = new ArrayList<>();
        list.add(str);
        jsonData.setData(list);
        return jsonData;
    }
}
