package com.kalix.qiao.cms.biz;

import com.google.gson.Gson;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;
import com.kalix.qiao.cms.api.biz.IColumnBeanService;
import com.kalix.qiao.cms.api.biz.IMenuBeanService;
import com.kalix.qiao.cms.api.dao.IMenuBeanDao;
import com.kalix.qiao.cms.entities.ColumnBean;
import com.kalix.qiao.cms.entities.MenuBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangpeng on 2018/5/13.
 */
public class MenuBeanServiceImpl extends GenericBizServiceImpl<IMenuBeanDao, MenuBean> implements IMenuBeanService {

    private IColumnBeanService columnBeanService;

    public void setColumnBeanService(IColumnBeanService columnBeanService) {
        this.columnBeanService = columnBeanService;
    }

    /**
     * wangpeng
     *
     * @param id findById
     * @return
     */
    @Override
    public JsonData getMenuById(long id) {
        MenuBean menuBean = dao.get(id);
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(menuBean.getColumnId()));
        list.add(String.valueOf(id));
        Gson gson = new Gson();
        String str = gson.toJson(list);
        list.clear();
        list.add(str);
        JsonData jsonData = new JsonData();
        jsonData.setData(list);
        return jsonData;
    }

    /**
     * 查询数据列表
     *
     * @return
     */
    @Override
    public JsonData getMenuList() {
        List<ColumnBean> columnBeanList = columnBeanService.getAllEntity();
        Map<String, ColumnBean> map = new HashMap<>();
        for (ColumnBean column : columnBeanList) {
            map.put(String.valueOf(column.getId()), column);
        }
        List<MenuBean> list = dao.find("select m from MenuBean m order by m.columnId , m.sequence");
        for (MenuBean menu : list) {
            ColumnBean columnBean = map.get(String.valueOf(menu.getColumnId()));
            if(menu.getColumnId() == 1){
                menu.setUrl("/"+columnBean.getUrl()+"#"+menu.getUrl());
            }else{
                menu.setUrl("/"+columnBean.getUrl()+"/"+menu.getUrl());
            }
            menu.setColumnName(columnBean.getName());
        }
        JsonData jsonData = new JsonData();
        jsonData.setData(list);
        jsonData.setTotalCount((long) list.size());
        return jsonData;
    }


}
