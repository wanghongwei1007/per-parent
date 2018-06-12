package com.kalix.qiao.genealogy.api.biz;

import com.kalix.framework.core.api.biz.IBizService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.qiao.genealogy.entities.GenealogyBean;

/**
 * Created by Administrator on 2018/5/13.
 */
public interface IGenealogyBeanService extends IBizService<GenealogyBean> {

    JsonData queryForTree();
}
