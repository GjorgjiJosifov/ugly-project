/**
 * 
 */
package org.dao.genericdao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * @author chemicalangel
 * 
 */
public abstract class BaseDB {

	@Inject
	protected EntityManager em;

}
