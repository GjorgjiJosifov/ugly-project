/**
 * 
 */
package org.dao.genericdao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author chemicalangel
 * 
 */
public abstract class BaseDB {

	@PersistenceContext
	protected EntityManager em;

}
