package org.dao.genericdao.simple;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.finki.auction.common.exceptions.CSNSException;

public interface IGenericDao {

	/** Persist the newInstance object into database */
	<T extends Serializable> void create(T newInstance) throws CSNSException;

	public <T extends Serializable, PK extends Serializable> Set<T> readMultipleObjects(
			Class<T> clazz, PK[] ids) throws CSNSException;

	/**
	 * Retrieve an object that was previously persisted to the database using
	 * the indicated id as primary key
	 */
	<T extends Serializable, PK extends Serializable> T readObject(
			Class<T> clazz, PK id);

	/** Save changes made to a persistent object. */
	<T extends Serializable> T updateObject(T transientObject)
			throws CSNSException;

	/** Remove an object from persistent storage in the database */
	<T extends Serializable> void deleteObject(T persistentObject);

	<T extends Serializable> List<T> findAll(Class<T> clazz);

	<T extends Serializable> List<T> findByExample(T exampleInstance,
			String... excludeProperty);

	<T extends Serializable, PK extends Serializable> T findById(
			Class<T> clazz, PK id, boolean lock);

	<T extends Serializable> List<T> findByProperties(Class<T> clazz,
			Map<String, Object> propertiesMap);

}