/**
 * 
 */
package org.finki.auction.common.convertors;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chemicalangel
 * 
 */
public class ObjectsTo
{

	public static <T> Map<String, Object> getMapFromObject(T inputObject, String... fieldsNames)
	{
		Map<String, Object> returnMap = new HashMap<>();
		Field[] objectFields = inputObject.getClass().getDeclaredFields();
		List<String> fieldsNameList = Arrays.asList(fieldsNames);
		try
		{
			for (Field objectField : objectFields)
			{
				String name = objectField.getName();
				if (fieldsNameList.contains(name))
				{
					objectField.setAccessible(true);
					Object valueInit;
					valueInit = objectField.get(inputObject);
					if (valueInit != null)
					{
						returnMap.put(name, valueInit);
					}
				}
			}
		} catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		return returnMap;

	}
}
