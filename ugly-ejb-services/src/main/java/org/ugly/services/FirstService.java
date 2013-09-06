/**
 * 
 */
package org.ugly.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

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

	@Override
	public List<SignupDetails> getAllSignupDetails() {
		return simpleDao.findAll(SignupDetails.class);
	}

}
