package org.dao.genericdao.simple;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.finki.auction.common.exceptions.CSNSException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

@Stateless
public class GenericDao extends org.dao.genericdao.BaseDB implements
		IGenericDao {
	public GenericDao() {
	}

	public GenericDao(EntityManager em) {
		this.em = em;
	}

	@Override
	public <T extends Serializable> void create(T newInstance)
			throws CSNSException {
		try {
			em.persist(newInstance);
		} catch (Exception e) {
			throw new CSNSException(e);
		}
	}

	@Override
	public <T extends Serializable, PK extends Serializable> T readObject(
			Class<T> clazz, PK id) {
		return (T) em.find(clazz, id);
	}

	@Override
	public <T extends Serializable, PK extends Serializable> Set<T> readMultipleObjects(
			Class<T> clazz, PK[] ids) throws CSNSException {
		if (ids.length == 0)
			return new HashSet<T>(0);
		try {
			CriteriaBuilder queryBuilder = em.getCriteriaBuilder();
			CriteriaQuery<T> query = queryBuilder.createQuery(clazz);
			Root<T> fromClazz = query.from(clazz);
			Predicate condition = queryBuilder.in(fromClazz.get("id")).value(
					ids);
			CriteriaQuery<T> finalQuery = query.select(fromClazz).where(
					condition);
			TypedQuery<T> exeQuery = em.createQuery(finalQuery);
			Set<T> returnResult = new HashSet<T>(exeQuery.getResultList());
			return returnResult;
		} catch (Exception e) {
			throw new CSNSException(e);
		}
	}

	@Override
	public <T extends Serializable> T updateObject(T transientObject)
			throws CSNSException {
		try {
			return em.merge(transientObject);
		} catch (Exception e) {
			throw new CSNSException(e);
		}
	}

	@Override
	public <T extends Serializable> void deleteObject(T persistentObject) {
		em.remove(persistentObject);
	}

	@Override
	public <T extends Serializable, PK extends Serializable> T findById(
			Class<T> clazz, PK id, boolean lock) {
		T entity;
		if (lock) {
			entity = em.find(clazz, id);
			em.lock(entity, javax.persistence.LockModeType.WRITE);
		} else {
			entity = em.find(clazz, id);
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Serializable> List<T> findAll(Class<T> clazz) {
		return em.createQuery("from " + clazz.getName()).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Serializable> List<T> findByExample(T exampleInstance,
			String... excludeProperty) {
		Session s = (Session) em.getDelegate();
		Class<?> clazz = exampleInstance.getClass();
		Criteria crit = s.createCriteria(clazz);
		Example example = Example.create(exampleInstance);
		for (String exclude : excludeProperty) {
			example.excludeProperty(exclude);
		}
		crit.add(example);

		return crit.list();
	}

	@Override
	public <T extends Serializable> List<T> findByProperties(Class<T> clazz,
			Map<String, Object> propertiesMap) {
		Set<String> properties = propertiesMap.keySet();
		CriteriaBuilder queryBuilder = em.getCriteriaBuilder();
		CriteriaQuery<T> query = queryBuilder.createQuery(clazz);
		Root<T> fromClazz = query.from(clazz);
		Predicate[] eqConditions = new Predicate[properties.size()];
		int i = 0;
		for (String property : properties) {
			Object value = propertiesMap.get(property);
			Predicate eqCond = queryBuilder.equal(fromClazz.get(property),
					value);
			eqConditions[i] = eqCond;
			i++;
		}

		Predicate whereCondition = queryBuilder.and(eqConditions);

		CriteriaQuery<T> finalQuery = query.select(fromClazz).where(
				whereCondition);
		TypedQuery<T> exeQuery = em.createQuery(finalQuery);

		return exeQuery.getResultList();
	}

}