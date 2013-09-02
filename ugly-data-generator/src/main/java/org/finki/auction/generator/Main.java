/**
 * 
 */
package org.finki.auction.generator;

import org.finki.auction.common.exceptions.AuctionException;
import org.finki.auction.common.exceptions.CSNSException;

/**
 * @author chemicalangel
 * 
 */
public class Main {

	/**
	 * @param args
	 * @throws AuctionException
	 */
	public static void main(String[] args) throws CSNSException {
		Executor dbInit = new Executor();
		dbInit.execute();
	}

}
