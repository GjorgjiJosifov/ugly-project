package com.googlecode.htmleasy.playground;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.htmleasy.playground.bizzlevel.BizzFacade;
import com.googlecode.htmleasy.playground.domain.DomainEntity;
import com.googlecode.htmleasy.playground.domain.ValidateResponse;

public abstract class GenericModel {

	protected List<String> errors;
	protected Object[] domainEntities;
	protected BizzFacade bizz;

	protected GenericModel(BizzFacade b, int numberOfEntities) {
		errors = new ArrayList<String>();
		domainEntities = new Object[numberOfEntities];
		this.bizz = b;
	}

	public GenericModel cloneModel(DomainEntity[] domainToClone) {
		domainEntities = null;
		domainEntities = new Object[domainToClone.length];

		for (int i = 0; i < domainToClone.length; i++) {
			this.domainEntities[i] = domainToClone[i].copyOf();
		}

		this.errors = new ArrayList<String>();
		return this;
	}

	public abstract GenericModel newModel();

	public abstract boolean validateModel();

	public abstract ValidateResponse ajaxValidator(Object... toBeValidate);

	public List<String> getErrors() {
		return errors;
	}

	public Object[] getDomains() {
		return domainEntities;
	}

}