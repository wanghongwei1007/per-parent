package com.kalix.qiao.genealogy.biz;

import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;
import com.kalix.qiao.genealogy.api.biz.IClansmanBeanService;
import com.kalix.qiao.genealogy.api.dao.IClansmanBeanDao;
import com.kalix.qiao.genealogy.entities.ClansmanBean;

/**
 * Created by wangpeng on 2018/6/15.
 */
public class ClansmanBeanServiceImpl extends GenericBizServiceImpl<IClansmanBeanDao, ClansmanBean> implements IClansmanBeanService {

    @Override
    public void deleteByGenealogyId(long id) {
        dao.deleteByGenealogyId(id);
    }
}
