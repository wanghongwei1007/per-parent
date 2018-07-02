package com.kalix.qiao.genealogy.biz;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;
import com.kalix.qiao.genealogy.api.biz.IRecordBeanService;
import com.kalix.qiao.genealogy.api.dao.IRecordBeanDao;
import com.kalix.qiao.genealogy.entities.GenerationBean;
import com.kalix.qiao.genealogy.entities.RecordBean;

import java.util.List;

/**
 * Created by wangpeng on 2018/6/22.
 */
public class RecordBeanServiceImpl extends GenericBizServiceImpl<IRecordBeanDao, RecordBean> implements IRecordBeanService {


    @Override
    public JsonData getRecordByClansmanId(long clansmanId) {
        List<RecordBean> recordBeanList = dao.find("select g from RecordBean g where g.clansmanId = ?1", clansmanId);
        JsonData jsonData = new JsonData();
        jsonData.setTotalCount((long) recordBeanList.size());
        jsonData.setData(recordBeanList);
        return jsonData;
    }

    @Override
    public void DeleteByClansmanId(long clansmanId) {
        dao.DeleteByClansmanId(clansmanId);
    }
}
