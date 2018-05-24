package com.kalix.qiao.cms.api.dao;

import com.kalix.framework.core.api.dao.IGenericDao;
import com.kalix.qiao.cms.entities.ContentBean;
import com.kalix.qiao.cms.entities.MenuBean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/13.
 */
public interface IContentBeanDao extends IGenericDao<ContentBean, Long> {
    List<MenuBean> getColumnAndMenu(int navid);
}
