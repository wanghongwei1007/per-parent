package com.kalix.per.uio.dao;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.per.uio.api.dao.IUioBeanDao;
import com.kalix.per.uio.entities.UioBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * 考题页
 */
public class UioBeanDaoImpl extends GenericDao<UioBean, Long> implements IUioBeanDao {

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

        final Query query = entityManager.createQuery("select Distinct c from " + className + " c " + "order by c.q_number");
        final List<UioBean> resultList = query.getResultList();
        long l = resultList.size();

        JsonData jsonData = new JsonData();

        jsonData.setData(resultList);
        jsonData.setTotalCount(l);
        return jsonData;
    }

}
