/**
 * 
 */
package org.dao.genericdao.complex.executor;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

public interface QueryExecutor {
	<T> List<T> executeMultiple(CriteriaQuery<T> criteriaQuery);

	<T extends Comparable<? super T>> List<T> executeSortableMultiple(
			CriteriaQuery<T> criteriaQuery);

	<T> T executeSingle(Query q);
}
