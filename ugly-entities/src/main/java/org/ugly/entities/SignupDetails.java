package org.ugly.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.ws.rs.FormParam;

import org.ugly.interfaces.DomainEntity;

/**
 * Simple POJO to store user signup form information.
 * 
 */
@Entity
public class SignupDetails extends AbstractEntity implements DomainEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6048317287748119868L;

	@Id
	@GeneratedValue
	private Long id;

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

	public SignupDetails(Importer builder) {
		builder.open();
		this.agreedLegal = builder.provideAgreedLegal();
		this.confirmPassword = builder.provideConfirmPassword();
		this.password = builder.providePassword();
		this.sex = builder.provideSex();
		this.username = builder.provideUsername();
		builder.close();
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

	public interface Importer {
		void open();

		void close();

		String provideUsername();

		String providePassword();

		String provideConfirmPassword();

		Sex provideSex();

		boolean provideAgreedLegal();
	}

}
