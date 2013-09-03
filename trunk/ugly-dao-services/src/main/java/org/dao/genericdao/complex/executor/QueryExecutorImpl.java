package org.dao.genericdao.complex.executor;

import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.dao.genericdao.BaseDB;

@Stateless
@Transactional(value = TxType.MANDATORY)
public class QueryExecutorImpl extends BaseDB implements QueryExecutor {

	@Override
	public <T> List<T> executeMultiple(CriteriaQuery<T> criteriaQuery) {
		return em.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public <T extends Comparable<? super T>> List<T> executeSortableMultiple(
			CriteriaQuery<T> criteriaQuery) {
		List<T> returnList = em.createQuery(criteriaQuery).getResultList();
		Collections.sort(returnList);
		return returnList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T executeSingle(Query q) {
		return (T) q.getSingleResult();
	}
}
