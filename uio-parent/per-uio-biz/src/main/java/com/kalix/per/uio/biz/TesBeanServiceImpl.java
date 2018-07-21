package com.kalix.per.uio.biz;

import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.api.persistence.PersistentEntity;
import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;
import com.kalix.framework.core.util.SerializeUtil;
import com.kalix.per.uio.api.biz.ITesBeanService;
import com.kalix.per.uio.api.dao.ITesBeanDao;
import com.kalix.per.uio.entities.TesBean;

import javax.transaction.Transactional;
import java.awt.event.TextListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>www.bjpowernode.com</p>
 *
 * @DATE 2018.07.20 下午 02:38
 * TesBeanServiceImpl zhaoyade
 */
public class TesBeanServiceImpl extends GenericBizServiceImpl<ITesBeanDao, TesBean> implements ITesBeanService {

    /**
     * 添加考试结果
     * @return
     */
    @Override
    @Transactional
    public JsonStatus saveTes(String strings) {
        String s1 = strings;
        Map<String, Object> jsonMap = SerializeUtil.jsonToMap(strings);
        //返回对象
        JsonStatus jsonStatus = new JsonStatus();
        // 数据库对象
        TesBean tesBean = new TesBean();
        // 对象集合
        List<TesBean> tList = new ArrayList<>();

        //解析字符串
        String items = (String) jsonMap.get("str");
        String[] subStr = items.split("-");

        for (int i=0; i<subStr.length; i++) {
            String s = subStr[i];

            tesBean.setR_option(s.substring(0, 1));
            tesBean.setR_answer(s.substring(5, 6));
            tesBean.setR_num(s.substring(6, 8));
            // 判断题是否对
            if (s.substring(0, 1).equals(s.substring(5, 6))) {
                tesBean.setR_result("正确");
            } else {
                tesBean.setR_result("错误");
            }

            this.saveEntity(tesBean);
        }

        // 返回值
        jsonStatus.setTag("");
        jsonStatus.setMsg("成功");
        jsonStatus.setSuccess(true);
        jsonStatus.setFailure(false);
        return jsonStatus;
    }
}