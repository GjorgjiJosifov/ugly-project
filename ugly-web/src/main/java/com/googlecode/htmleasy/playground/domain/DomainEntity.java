/**
 * 
 */
package com.googlecode.htmleasy.playground.domain;

import java.util.List;

/**
 * @author gjorgji
 *
 */
public interface DomainEntity {

	void validate(List<String> listOfErrors);
	DomainEntity copyOf();
	Object[] getAjaxValidatorFields();
	
}
