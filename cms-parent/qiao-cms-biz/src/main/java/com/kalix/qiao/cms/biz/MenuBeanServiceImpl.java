package com.kalix.qiao.cms.biz;

import com.google.gson.Gson;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;
import com.kalix.qiao.cms.api.biz.IMenuBeanService;
import com.kalix.qiao.cms.api.dao.IMenuBeanDao;
import com.kalix.qiao.cms.entities.MenuBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/13.
 */
public class MenuBeanServiceImpl extends GenericBizServiceImpl<IMenuBeanDao, MenuBean> implements IMenuBeanService{


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
}
