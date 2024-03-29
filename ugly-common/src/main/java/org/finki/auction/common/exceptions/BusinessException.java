package org.finki.auction.common.exceptions;

/**
 * This exception is used to mark business rule violations.
 * 
 * @author Christian Bauer
 */
@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {

	public static final String ERROR_MSG = "business_error_msg";

	public BusinessException() {
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}
}
