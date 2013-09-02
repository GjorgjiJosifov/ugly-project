/**
 * 
 */
package org.finki.auction.generator;

import java.util.LinkedList;

import org.finki.auction.common.exceptions.CSNSException;
import org.finki.auction.generator.data.SignupDetailsData;

/**
 * @author chemicalangel
 * 
 */
public class Executor {
	private LinkedList<Data<?>> queData = new LinkedList<>();

	public Executor() {
		SignupDetailsData address = new SignupDetailsData();
		address.init();
		queData.add(address);
	}

	public void execute() throws CSNSException {
		System.out.println("Start");
		while (!queData.isEmpty()) {
			Data<?> tmpData = queData.removeFirst();
			if (tmpData.create()) {
				tmpData.persist();
			} else {
				queData.addLast(tmpData);
			}
		}
		System.out.println("End");
	}

}
