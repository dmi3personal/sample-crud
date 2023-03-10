package com.ds.sample;

/**
 * Exception describing an error of a user-management operation.
 */
public class UserManagementException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates an error not caused by an exception.
	 * @param message Error message.
	 */
	public UserManagementException(String message) {
		super(message);
	}

	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public UserManagementException(String message, Throwable cause) {
		super(message, cause);
	}

}
