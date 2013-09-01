/**
 * 
 */
package org.finki.auction.common.exceptions;

/**
 * @author chemicalangel
 *
 */
public class AuctionException extends Exception {	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1327233368558949305L;

	public AuctionException() {}

	public AuctionException(String message) {
		super(message);
	}

	public AuctionException(String message, Throwable cause) {
		super(message, cause);
	}

	public AuctionException(Throwable cause) {
		super(cause);
	}
}
