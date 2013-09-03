/**
 * 
 */
package org.ugly.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.dao.genericdao.DaoComplexFacade;
import org.dao.genericdao.complex.executor.QueryExecutor;
import org.dao.genericdao.simple.GenericDao;
import org.ugly.entities.SignupDetails;
import org.ugly.interfaces.services.FirstEJBService;

/**
 * @author gjorgji
 * 
 */
@Stateless(name = "FirstEJBService")
public class FirstService implements FirstEJBService {

	@Inject
	private GenericDao simpleDao;

	@Inject
	private QueryExecutor complexExecutor;

	@Inject
	private DaoComplexFacade complexDao;

	@Override
	public List<SignupDetails> getAllSignupDetails() {
		return simpleDao.findAll(SignupDetails.class);
	}

	@Override
	public Integer countSignupDetails() {
		return complexExecutor.executeSingle(complexDao.countSignupDetails());
	}

}
