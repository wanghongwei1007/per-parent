package com.kalix.qiao.cms.api.biz;

import com.kalix.framework.core.api.biz.IBizService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.qiao.cms.entities.MenuBean;

/**
 * Created by Administrator on 2018/5/13.
 */
public interface IMenuBeanService extends IBizService<MenuBean> {

    /**
     *
     * @param id findById
     * @return
     * wangpeng 2018-5-28
     */
    JsonData getMenuById(long id);

    /**
     * 数据集合
     * @return
     */
    JsonData getMenuList();
}
