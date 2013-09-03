/**
 * 
 */
package com.googlecode.htmleasy.playground;

import com.googlecode.htmleasy.View;
import com.googlecode.htmleasy.playground.bizzlevel.BizzFacade;
import com.googlecode.htmleasy.playground.domain.DomainEntity;

/**
 * @author gjorgji
 * 
 */
public abstract class GenericController<M extends GenericModel> {

	protected M model;
	protected String returnGet;
	protected String returnFailOnPost;

	protected BizzFacade bizz;

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
