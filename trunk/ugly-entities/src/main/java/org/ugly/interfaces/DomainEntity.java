/**
 * 
 */
package org.ugly.interfaces;

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
