package com.kalix.qiao.genealogy.api.biz;

import com.kalix.framework.core.api.biz.IBizService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.qiao.genealogy.entities.GenerationBean;

/**
 * Created by wangpeng on 2018/6/22.
 */
public interface IGenerationBeanService extends IBizService<GenerationBean> {

    JsonData getGenerationByGenealogyId(long genealogyId);

    JsonData getGenerationForSelect(long genealogyId);

    void DeleteByGenealogyId(long genealogyId);

}
