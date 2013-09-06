package com.googlecode.htmleasy.playground;

import com.googlecode.htmleasy.playground.domain.ValidateResponse;

/** Simple POJO to store our view model. */
public class ListSignupDetailsModel extends GenericModel {

	public ListSignupDetailsModel() {
		super(null, 0);
	}

	@Override
	public GenericModel newModel() {
		this.domainEntities[0] = bizz.getAllSignupDetails();
		return this;
	}

	@Override
	public boolean validateModel() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ValidateResponse ajaxValidator(Object... toBeValidate) {
		throw new UnsupportedOperationException();
	}

}