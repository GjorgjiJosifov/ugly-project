package com.init.resources;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import javax.enterprise.inject.Produces;
import javax.naming.InitialContext;

import com.googlecode.htmleasy.playground.bizzlevel.BizzFacade;

public class ResourceProducer {

	@Produces
	public BizzFacade produceBizzFacade() {
		Class<?>[] extendedInterfacesArray = BizzFacade.class.getInterfaces();
		int sExtends = extendedInterfacesArray.length;
		Class<?>[] interfacesArray = Arrays.copyOf(extendedInterfacesArray,
				sExtends + 1);

		interfacesArray[sExtends] = BizzFacade.class;

		return (BizzFacade) Proxy.newProxyInstance(getClass().getClassLoader(),
				interfacesArray, new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						Object ejbObject = new InitialContext()
								.lookup("java:module/"
										+ method.getDeclaringClass()
												.getSimpleName());
						return method.invoke(ejbObject, args);
					}
				});
	}
}
