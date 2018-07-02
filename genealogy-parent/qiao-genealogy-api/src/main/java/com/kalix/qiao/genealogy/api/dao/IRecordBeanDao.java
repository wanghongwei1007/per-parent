package com.kalix.qiao.genealogy.api.dao;

import com.kalix.framework.core.api.dao.IGenericDao;
import com.kalix.qiao.genealogy.entities.RecordBean;

/**
 * Created by wangpeng on 2018/6/15.
 */
public interface IRecordBeanDao extends IGenericDao<RecordBean, Long> {

    void DeleteByClansmanId(long clansmanId);
}
