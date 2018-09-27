package com.kalix.per.uio.dao;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.per.uio.api.dao.ITesBeanDao;
import com.kalix.per.uio.entities.TesBean;
import com.kalix.per.uio.entities.TestResultBean;
import org.apache.openjpa.persistence.EntityManagerImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Map;

/**
 * 考试持久层实现类
 */
public class TesBeanDaoImpl extends GenericDao<TesBean, Long> implements ITesBeanDao {

    @PersistenceContext(unitName = "uio-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }

    /**
     * 考试列表按题号排序
     * @param page
     * @param limit
     * @param criteriaQuery
     * @return
     */
    @Override
    public JsonData getAll(int page, int limit, CriteriaQuery criteriaQuery) {

        final Query query = entityManager.createQuery("select Distinct c from " + className + " c " +"order by c.r_name,c.r_num asc");
        final List<TesBean> resultList = query.getResultList();
        long l = resultList.size();

        JsonData jsonData = new JsonData();
        jsonData.setData(resultList);
        jsonData.setTotalCount(l);
        return jsonData;
    }

    /**
     * 面试结果插入分数
     * @param map
     * @return
     */
    @Override
    public int updateScoreByName(Map<String, Object> map) {
        String name =(String) map.get("name");
        int score =(int) map.get("score");
        // 纯生sql
        int i = this.updateNativeQuery("update per_reg set score =" + score + "where name = '" + name + "'");
        return i;
    }

    /**
     * 根据姓名进行连表查询
     * @param rName
     * @return resultList
     */
    @Override
    public JsonData queryListByName(String rName) {

        String sql = "select u.topic,u.a_option,u.b_option,u.c_option,u.d_option,u.correct,u.q_number,t.r_option,t.r_score " +
                "from per_uio u " +
                "left join per_uio_tes t " +
                "on u.q_number = t.r_num " +
                "where t.r_name = '" + rName +"'";

        List<TestResultBean> resList = entityManager.createNativeQuery(sql).getResultList();

        long l = resList.size();
        JsonData jsonData = new JsonData();
        jsonData.setData(resList);
        jsonData.setTotalCount(l);
        return jsonData;
    }
}
