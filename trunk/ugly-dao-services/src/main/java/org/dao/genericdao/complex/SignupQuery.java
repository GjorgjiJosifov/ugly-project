package org.dao.genericdao.complex;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Stateless(name = "ISignupQuery")
public class SignupQuery implements ISignupQuery {

	@Inject
	private EntityManager entityManager;

	@Override
	public Query countSignupDetails() {
		String query = "select COUNT(sd) from SignupDetails as sd";
		return entityManager.createQuery(query);
	}

}
