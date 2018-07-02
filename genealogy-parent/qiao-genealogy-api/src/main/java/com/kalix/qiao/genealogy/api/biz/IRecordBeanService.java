package com.kalix.qiao.genealogy.api.biz;

import com.kalix.framework.core.api.biz.IBizService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.qiao.genealogy.entities.RecordBean;

/**
 * Created by wangpeng on 2018/6/22.
 */
public interface IRecordBeanService extends IBizService<RecordBean> {

    JsonData getRecordByClansmanId(long clansmanId);

    void DeleteByClansmanId(long clansmanId);

}
