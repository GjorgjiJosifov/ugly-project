package com.googlecode.htmleasy.playground;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.jboss.resteasy.annotations.Form;
import org.ugly.entities.SignupDetails;
import org.ugly.interfaces.DomainEntity;
import org.ugly.service.facade.EJBServiceFacade;

import com.googlecode.htmleasy.RedirectException;
import com.googlecode.htmleasy.View;
import com.googlecode.htmleasy.playground.domain.ValidateResponse;

@Path("/signup")
@RequestScoped
public class UserSignup extends GenericController<UserModel> {

	public UserSignup() {
		super();
		this.returnGet = "/WEB-INF/templates/playground/signup/form.jsp";
		this.returnFailOnPost = "/WEB-INF/templates/playground/signup/form.jsp";
	}

	@Inject
	public void setBizzFacade(EJBServiceFacade b) {
		this.bizz = b;
		this.model = new UserModel(b);
	}

	@GET
	public View showSignupForm() {
		return defaultGet();
	}

	@POST
	public View processSignup(@Form SignupDetails signupDetails) {
		return defaultPost(new DomainEntity[] { signupDetails });
	}

	@GET
	@Path("/thanks")
	public View showSignupThanks() {
		return new View("/WEB-INF/templates/playground/signup/thanks.jsp");
	}

	/**
	 * Validate a username server-side to ensure it's suitable for the signup
	 * process.
	 * 
	 * This method is exposed to the web view layer via AJAX as well as used
	 * directly in Java when processing the post.
	 * 
	 * Note: Of course in a real application some of the validation in this
	 * method would be done client-side, however some tasks such as the
	 * availability of a username can only be done server-side.
	 * 
	 * @param username
	 *            The username to validate.
	 * @return A response object containing the validation status and a message.
	 */
	@Path("/validate_username")
	@POST
	@Produces("application/json")
	public ValidateResponse usernameValidator(
			@FormParam("username") String username) {
		return model.ajaxValidator(new Object[] { username });
	}

	@Override
	protected View successfullPostHandler() {
		throw new RedirectException("/signup/thanks");
	}

}
