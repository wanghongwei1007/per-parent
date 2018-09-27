package com.kalix.per.uio.biz;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.api.persistence.PersistentEntity;
import com.kalix.framework.core.api.web.model.BaseDTO;
import com.kalix.framework.core.api.web.model.QueryDTO;
import com.kalix.framework.core.impl.biz.GenericBizServiceImpl;
import com.kalix.framework.core.util.Assert;
import com.kalix.framework.core.util.SerializeUtil;
import com.kalix.per.uio.api.biz.ITesBeanService;
import com.kalix.per.uio.api.dao.ITesBeanDao;
import com.kalix.per.uio.api.dao.IUioBeanDao;
import com.kalix.per.uio.entities.TesBean;
import com.kalix.per.uio.entities.UioBean;
import org.apache.openjpa.json.JSON;

import javax.transaction.Transactional;
import java.awt.event.TextListener;
import java.util.*;

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
    public JsonStatus saveTes(String rStr) {
        // 总分数
        int score = 0;
        //返回对象
        JsonStatus jsonStatus = new JsonStatus();
        // 解析字符串
        String sName = rStr.substring((rStr.indexOf("_")+1));
        String sContent = rStr.substring(0, rStr.indexOf("_"));
        //字符串转数组
        String[] subStr = sContent.split("-");

        for (int i=0; i<subStr.length; i++) {
            // 数据库对象
            TesBean tesBean = new TesBean();
            String s = subStr[i];
            tesBean.setR_name(sName);
            tesBean.setR_option(s.substring(0, 1));
            tesBean.setR_answer(s.substring(5, 6));
            tesBean.setR_num(Integer.parseInt(s.substring(6)));
            // 判断题是否对
            if (s.substring(0, 1).equals(s.substring(5, 6))) {
                tesBean.setR_result("正确");
                tesBean.setR_score(score = score + 4);
            } else {
                tesBean.setR_result("错误");
                tesBean.setR_score(score);
            }
            // 存储到数据库
            this.doSave(tesBean, new JsonStatus());
        }

        // 更新面试表添加分数
        Map<String, Object> map = new HashMap<>();
        map.put("name", sName);
        map.put("score", score);
        int ret = dao.updateScoreByName(map);

        if (ret > 0) {
            jsonStatus.setTag("");
            jsonStatus.setMsg("成功");
            jsonStatus.setSuccess(true);
            jsonStatus.setFailure(false);
        } else {
            jsonStatus.setTag("");
            jsonStatus.setMsg("失败");
            jsonStatus.setSuccess(false);
            jsonStatus.setFailure(true);
        }
        return jsonStatus;

    }

    /**
     * 按名称查询 考试结果
     * @param rName
     * @return
     */
    @Override
    public JsonData getListByName(String rName) {
        // 考试结果
        JsonData jsonData = dao.queryListByName(rName);
        return jsonData;
    }
}