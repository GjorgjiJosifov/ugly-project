/**
 * 
 */
package com.googlecode.htmleasy.playground;

import org.ugly.interfaces.DomainEntity;
import org.ugly.service.facade.EJBServiceFacade;

import com.googlecode.htmleasy.View;

/**
 * @author gjorgji
 * 
 */
public abstract class GenericController<M extends GenericModel> {

	protected M model;
	protected String returnGet;
	protected String returnFailOnPost;

	protected EJBServiceFacade bizz;

	public View defaultGet() {
		return new View(returnGet, model.newModel());
	}

	public View defaultPost(DomainEntity[] httpDomainObject) {
		GenericModel m = (GenericModel) model.cloneModel(httpDomainObject);

		if (!m.validateModel()) {
			return new View(returnFailOnPost, m);
		}
		return successfullPostHandler();
	}

	protected abstract View successfullPostHandler();

}
