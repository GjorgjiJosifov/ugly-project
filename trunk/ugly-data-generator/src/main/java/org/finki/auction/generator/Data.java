/**
 * 
 */
package org.finki.auction.generator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.dao.genericdao.simple.GenericDao;
import org.dao.genericdao.simple.IGenericDao;
import org.finki.auction.common.exceptions.CSNSException;
import org.fluttercode.datafactory.impl.DataFactory;

/**
 * @author chemicalangel
 * 
 */
public abstract class Data<T extends Serializable> {

	protected IGenericDao dao;
	protected DataFactory dataGenerator = new DataFactory();
	protected final Integer NUMBER_OF_INSTANCES = 20;
	protected boolean isCreated = true;
	protected List<T> persistedObjects = new ArrayList<>(0);
	private static EntityManagerFactory EMF;
	protected static EntityManager em;

	//
	public void persist() throws CSNSException {
		em.getTransaction().begin();
		for (Serializable object : persistedObjects) {
			dao.create(object);
		}
		em.getTransaction().commit();
	}

	//
	public boolean create() {
		for (int i = 0; i < NUMBER_OF_INSTANCES; i++) {
			T persistObject = newInstance();
			if (!isCreated) {
				return isCreated;
			} else {
				persistedObjects.add(persistObject);
			}
		}
		return true;
	}

	//
	public abstract T newInstance();

	//
	public void init() {
		dao = new GenericDao(em);
	}

	static {
		EMF = Persistence.createEntityManagerFactory("dataGeneratorUnit");
		em = EMF.createEntityManager();
	}

}
