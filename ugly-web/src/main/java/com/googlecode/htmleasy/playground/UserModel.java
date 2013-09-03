package com.googlecode.htmleasy.playground;

import com.googlecode.htmleasy.playground.bizzlevel.BizzFacade;
import com.googlecode.htmleasy.playground.domain.SignupDetails;
import com.googlecode.htmleasy.playground.domain.ValidateResponse;

/** Simple POJO to store our view model. */
public class UserModel extends GenericModel {

	public UserModel(BizzFacade b) {
		super(b, 1);
	}

	@Override
	public GenericModel newModel() {
		this.domainEntities[0] = bizz.getDefaultValues();
		return this;
	}

	@Override
	public boolean validateModel() {
		SignupDetails domainToBeValidate = ((SignupDetails) domainEntities[0]);
		domainToBeValidate.validate(errors);
		ValidateResponse response = ajaxValidator(domainToBeValidate
				.getAjaxValidatorFields());

		if (!response.isValid()) {
			this.errors.add(response.getMessage());
		}

		return errors.size() == 0;
	}

	@Override
	public ValidateResponse ajaxValidator(Object... toBeValidate) {
		String username = toBeValidate[0].toString();
		if (username == null || username.length() == 0) {
			return new ValidateResponse(false, "Please enter a username.");
		} else if (username.startsWith("admin") || username.equals("john")) {
			return new ValidateResponse(false,
					"This username is already taken.");
		} else if (username.length() < 4) {
			return new ValidateResponse(false,
					"Usernames must be 4 or more letters.");
		} else if (username.contains(" ")) {
			return new ValidateResponse(false,
					"Usernames must not contain spaces.");
		}
		return ValidateResponse.VALID;
	}

}