/**
 * 
 */
package com.googlecode.htmleasy.playground.bizzlevel;

import javax.ejb.Stateless;

import com.googlecode.htmleasy.playground.domain.SignupDetails;

/**
 * @author gjorgji
 * 
 */
@Stateless(name = "DefaultBussinessService")
public class DefaultValueBussinesService implements DefaultBussinessService {

	@Override
	public SignupDetails getDefaultValues() {
		return SignupDetails.getDefault();
	}

}
