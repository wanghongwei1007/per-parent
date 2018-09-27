package com.kalix.per.uio.api.dao;

import com.kalix.framework.core.api.dao.IGenericDao;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.per.uio.entities.TesBean;

import java.util.List;
import java.util.Map;

/**
 * 考试结果持久层接口
 */
public interface ITesBeanDao extends IGenericDao<TesBean, Long> {

    // 根据名字进行查询面试结果
    JsonData queryListByName(String rName);

    // 插入面试结果
    int updateScoreByName(Map<String, Object> map);

}
