package com.googlecode.htmleasy.playground.domain;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;

/**
 * Simple POJO to store user signup form information.
 * 
 */
public class SignupDetails implements DomainEntity {

	public static enum Sex {
		Male, Female, Unknown
	};

	@FormParam("username")
	private String username = "";

	@FormParam("password")
	private String password = "";

	@FormParam("confirmPassword")
	private String confirmPassword = "";

	@FormParam("sex")
	private Sex sex = Sex.Unknown;

	@FormParam("agreedLegal")
	private boolean agreedLegal;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isAgreedLegal() {
		return agreedLegal;
	}

	public void setAgreedLegal(boolean agreedLegal) {
		this.agreedLegal = agreedLegal;
	}

	@Override
	public void validate(List<String> listOfErrors) {
		// Validate password
		if (password.length() < 5) {
			listOfErrors.add("You need a stronger password!");
		} else if (!password.equals(confirmPassword)) {
			listOfErrors.add("Your password does not match!");
		}

		// Validate sex
		if (sex == Sex.Unknown) {
			listOfErrors.add("Please select a sex.");
		}

		// Validate Legal
		if (!agreedLegal) {
			listOfErrors.add("You must agree to the legal terms.");
		}
	}

	@Override
	public DomainEntity copyOf() {
		SignupDetails returnObject = new SignupDetails();
		returnObject.agreedLegal = this.agreedLegal;
		returnObject.confirmPassword = this.confirmPassword;
		returnObject.password = this.password;
		returnObject.sex = this.sex;
		returnObject.username = this.username;
		return returnObject;
	}

	@Override
	public Object[] getAjaxValidatorFields() {
		return new Object[] { this.username };
	}

	public static List<SignupDetails> getDummyList() {
		return new ArrayList<SignupDetails>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add(new SignupDetails("user1", Sex.Male));
				add(new SignupDetails("user2", Sex.Female));
				add(new SignupDetails("user3", Sex.Unknown));
			}
		};
	}

	public SignupDetails(String username, Sex sex) {
		super();
		this.username = username;
		this.sex = sex;
	}

	public SignupDetails() {
	}

	public static SignupDetails getDefault() {
		SignupDetails d = new SignupDetails();
		d.username = "default username";
		d.password = "default password";
		d.confirmPassword = "default confirm pass";
		d.sex = Sex.Unknown;
		d.agreedLegal = false;
		return d;
	}

}
