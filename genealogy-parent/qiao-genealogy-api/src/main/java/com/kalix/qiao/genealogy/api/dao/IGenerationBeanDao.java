package com.kalix.qiao.genealogy.api.dao;

import com.kalix.framework.core.api.dao.IGenericDao;
import com.kalix.qiao.genealogy.entities.GenerationBean;

/**
 * Created by wangpeng on 2018/6/15.
 */
public interface IGenerationBeanDao extends IGenericDao<GenerationBean, Long> {

    void DeleteByGenealogyId(long genealogyId);
}
