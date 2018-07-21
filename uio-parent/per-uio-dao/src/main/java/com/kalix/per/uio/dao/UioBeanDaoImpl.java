package com.kalix.per.uio.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.per.uio.api.dao.IUioBeanDao;
import com.kalix.per.uio.entities.UioBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
     * 考试列表升序查询
     * @return
     */
    @Override
    public List<UioBean> getAllDistinct() {
        final Query query = entityManager.createQuery("select Distinct c from " + className + " c " + "where c.q_number=1");
        final List<UioBean> resultList = query.getResultList();
        return resultList;
    }
}
