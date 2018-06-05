package com.kalix.qiao.genealogy.api.dao;

import com.kalix.framework.core.api.dao.IGenericDao;
import com.kalix.qiao.genealogy.entities.ClansmanBean;
import com.kalix.qiao.genealogy.entities.GenealogyBean;
import java.util.List;

/**
 * Created by Administrator on 2018/5/13.
 */
public interface IGenealogyBeanDao extends IGenericDao<GenealogyBean, Long> {
    List <GenealogyBean> getGenealogyByGeneId (long geneId);

    List <ClansmanBean> getClansmanByClansId (long clansId);

}
