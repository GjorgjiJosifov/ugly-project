package org.ugly.services.resources;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import javax.enterprise.inject.Produces;
import javax.naming.InitialContext;

import org.dao.genericdao.DaoComplexFacade;

public class ResourceManagement {

	@Produces
	public DaoComplexFacade createComplexDaoFacade() {
		Class<?>[] extendedInterfacesArray = DaoComplexFacade.class
				.getInterfaces();
		int sExtends = extendedInterfacesArray.length;
		Class<?>[] interfacesArray = Arrays.copyOf(extendedInterfacesArray,
				sExtends + 1);

		interfacesArray[sExtends] = DaoComplexFacade.class;

		return (DaoComplexFacade) Proxy.newProxyInstance(getClass()
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
