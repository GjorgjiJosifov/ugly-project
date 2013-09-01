package org.finki.auction.common.exceptions;

/**
 * This exception is used to mark access violations.
 * 
 * @author Christian Bauer
 */
@SuppressWarnings("serial")
public class PermissionException extends RuntimeException {

	public PermissionException() {
	}

	public PermissionException(String message) {
		super(message);
	}

	public PermissionException(String message, Throwable cause) {
		super(message, cause);
	}

	public PermissionException(Throwable cause) {
		super(cause);
	}
}
