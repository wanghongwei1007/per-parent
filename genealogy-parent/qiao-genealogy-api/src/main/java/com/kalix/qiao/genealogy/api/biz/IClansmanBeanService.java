package com.kalix.qiao.genealogy.api.biz;

import com.kalix.framework.core.api.biz.IBizService;
import com.kalix.qiao.genealogy.entities.ClansmanBean;

/**
 * Created by Administrator on 2018/5/13.
 */
public interface IClansmanBeanService extends IBizService<ClansmanBean> {

    void deleteByGenealogyId(long id);
}
