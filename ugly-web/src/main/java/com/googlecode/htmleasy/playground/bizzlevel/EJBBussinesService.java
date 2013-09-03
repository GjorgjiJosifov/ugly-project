/**
 * 
 */
package com.googlecode.htmleasy.playground.bizzlevel;

import java.util.List;

import javax.ejb.Stateless;

import com.googlecode.htmleasy.playground.domain.SignupDetails;

/**
 * @author gjorgji
 * 
 */
@Stateless(name = "BussinessService")
public class EJBBussinesService implements BussinessService {

	@Override
	public List<SignupDetails> getAllSignupDetails() {
		return SignupDetails.getDummyList();
	}

}
