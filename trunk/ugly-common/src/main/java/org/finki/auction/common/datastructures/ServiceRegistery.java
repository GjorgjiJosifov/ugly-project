/**
 * 
 */
package org.finki.auction.common.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author chemicalangel
 * 
 */
public class ServiceRegistery
{
	private Map<String, String> services = new HashMap<>();

	public static class ServiceEntry
	{
		private String serviceName;
		private String methodName;

		public ServiceEntry(String serviceName)
		{
			this.serviceName = serviceName;
		}

		@Override
		public int hashCode()
		{
			return Objects.hash(methodName);
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ServiceEntry other = (ServiceEntry) obj;

			return Objects.equals(this.methodName, other.methodName);
		}

	}

	public String getServiceName(String methodName)
	{
		return services.get(methodName);
	}
}
