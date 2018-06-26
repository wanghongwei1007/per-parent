package com.kalix.qiao.system.dict.api.biz;

import com.kalix.framework.core.api.system.IDictBeanService;
import com.kalix.qiao.system.dict.entities.QiaoDictBean;

import java.io.UnsupportedEncodingException;
import java.util.List;


public interface IQiaoDictBeanService extends IDictBeanService<QiaoDictBean> {
    List getLabelByType(String type) throws UnsupportedEncodingException;
}
