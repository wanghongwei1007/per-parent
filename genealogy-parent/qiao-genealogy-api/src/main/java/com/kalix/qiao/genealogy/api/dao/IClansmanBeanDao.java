package com.kalix.qiao.genealogy.api.dao;

import com.kalix.framework.core.api.dao.IGenericDao;
import com.kalix.qiao.genealogy.entities.ClansmanBean;

/**
 * Created by wangpeng on 2018/6/15.
 */
public interface IClansmanBeanDao extends IGenericDao<ClansmanBean, Long> {

    void deleteByGenealogyId(long id);
}
