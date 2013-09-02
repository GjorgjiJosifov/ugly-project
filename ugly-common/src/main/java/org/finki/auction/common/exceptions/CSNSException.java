/**
 * 
 */
package org.finki.auction.common.exceptions;

/**
 * @author chemicalangel
 * 
 */
public class CSNSException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1327233368558949305L;

	public CSNSException() {
	}

	public CSNSException(String message) {
		super(message);
	}

	public CSNSException(String message, Throwable cause) {
		super(message, cause);
	}

	public CSNSException(Throwable cause) {
		super(cause);
	}
}
