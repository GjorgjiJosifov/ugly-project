package org.dao.resources;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ResourceManagment {

	@PersistenceContext(unitName="appPU")
	@Produces
	private EntityManager entityManager;

}
