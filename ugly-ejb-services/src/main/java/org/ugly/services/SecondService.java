/**
 * 
 */
package org.ugly.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.dao.genericdao.DaoComplexFacade;
import org.dao.genericdao.complex.executor.QueryExecutor;
import org.ugly.interfaces.services.SecondEJBService;

/**
 * @author gjorgji
 * 
 */
@Stateless(name = "SecondEJBService")
public class SecondService implements SecondEJBService {

	@Inject
	private QueryExecutor complexExecutor;

	@Inject
	private DaoComplexFacade complexDao;

	@Override
	public Long countSignupDetails() {
		return complexExecutor.executeSingle(complexDao.countSignupDetails());
	}

}
