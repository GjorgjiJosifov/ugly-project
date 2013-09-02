/**
 * 
 */
package org.finki.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 * @author chemicalangel
 * 
 */

public class TestClass
{

	@SuppressWarnings("unused")
	private static EntityManagerFactory EMF;
	private static EntityManager EM;

	protected TestClass()
	{

	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// // Creating resources
		// EMF = Persistence.createEntityManagerFactory("AuctionUNIT");
		// EM = EMF.createEntityManager();
		//
		// // Create
		// Item i = new Item();
		// i.setApprovalDatetime(new Date());
		// System.out.println("Before saving : " + i);
		// save(i);
		// System.out.println("After saving : " + i);
		//
		// // Read
		// Item retr = get(Item.class, i.getId());
		// System.out.println("Retrieved I : " + retr);
		//
		// // Update
		// i.setApprovalDatetime(new Date());
		// System.out.println("Updated : " + i);
		// update(i);
		// retr = get(Item.class, i.getId());
		// System.out.println("Retrieved II : " + retr);
		//
		// // Delete
		// System.out.println("Deleting : " + i);
		// delete(i);
		// retr = get(Item.class, i.getId());
		// System.out.println("Retrieved III : " + retr);
		//
		// // Closing resources
		// EM.close();
		// EMF.close();
	}

	transient int a;

	public static void save(Object o)
	{

		EntityTransaction et = EM.getTransaction();
		et.begin();
		EM.persist(o);
		et.commit();

	}

	public static <T> T get(Class<T> entityType, Object key)
	{

		return EM.find(entityType, key);

	}

	public static void update(Object o)
	{

		EntityTransaction et = EM.getTransaction();
		et.begin();
		EM.merge(o);
		et.commit();

	}

	public static void delete(Object o)
	{

		EntityTransaction et = EM.getTransaction();
		et.begin();
		EM.remove(o);
		et.commit();

	}
}
