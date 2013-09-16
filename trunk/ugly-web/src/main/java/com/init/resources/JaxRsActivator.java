package com.init.resources;

import java.util.HashSet;
import java.util.Set;


import javax.ws.rs.core.Application;

import com.googlecode.htmleasy.HtmleasyProviders;
import com.googlecode.htmleasy.playground.UserSignup;


public class JaxRsActivator extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> myServices = new HashSet<Class<?>>();

		// Add my own JAX-RS annotated classes
		myServices.add(UserSignup.class);		

		// Add Htmleasy Providers
		myServices.addAll(HtmleasyProviders.getClasses());

		return myServices;
	}

}
