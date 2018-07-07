package com.kalix.qiao.genealogy.api.biz;

import com.kalix.framework.core.api.biz.IBizService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.qiao.genealogy.entities.GenealogyBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/13.
 */
public interface IGenealogyBeanService extends IBizService<GenealogyBean> {

    JsonData queryForTree();

    JsonData findById(long id);

    JsonData deleteById(long id);

    Map<String, Object> exportExcel(long id);

    void writeSVCFile(long id);

}
