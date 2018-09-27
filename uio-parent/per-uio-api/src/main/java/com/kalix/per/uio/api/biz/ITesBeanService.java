package com.kalix.per.uio.api.biz;

import com.kalix.framework.core.api.biz.IBizService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.per.uio.entities.TesBean;

/**
 * 考试列表业务层接口
 */
public interface ITesBeanService extends IBizService<TesBean> {

    // 添加
    JsonStatus saveTes(String rStr);

    // 按姓名查询
    JsonData getListByName(String name);
}
