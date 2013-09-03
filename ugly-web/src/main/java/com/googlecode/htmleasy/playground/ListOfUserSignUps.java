/**
 * 
 */
package com.googlecode.htmleasy.playground;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import com.googlecode.htmleasy.View;

/**
 * @author gjorgji
 * 
 */
@Path("/signup/list")
public class ListOfUserSignUps extends
		GenericController<ListSignupDetailsModel> {

	public ListOfUserSignUps() {
		this.returnGet = "/WEB-INF/templates/playground/signup/signuplist.jsp";
		this.model = new ListSignupDetailsModel();
	}

	@GET
	public View getAll() {
		return super.defaultGet();
	}

	@Override
	protected View successfullPostHandler() {
		throw new NotImplementedException();
	}
}
