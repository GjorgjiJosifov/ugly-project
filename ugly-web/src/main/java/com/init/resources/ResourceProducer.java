package com.init.resources;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import javax.enterprise.inject.Produces;
import javax.naming.InitialContext;

import org.ugly.service.facade.EJBServiceFacade;

public class ResourceProducer {

	@Produces
	public EJBServiceFacade createEJBFacade() {
		Class<?>[] extendedInterfacesArray = EJBServiceFacade.class
				.getInterfaces();
		int sExtends = extendedInterfacesArray.length;
		Class<?>[] interfacesArray = Arrays.copyOf(extendedInterfacesArray,
				sExtends + 1);

		interfacesArray[sExtends] = EJBServiceFacade.class;

		return (EJBServiceFacade) Proxy.newProxyInstance(getClass()
				.getClassLoader(), interfacesArray, new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				Object ejbObject = new InitialContext().lookup("java:module/"
						+ method.getDeclaringClass().getSimpleName());
				return method.invoke(ejbObject, args);
			}
		});
	}
}
