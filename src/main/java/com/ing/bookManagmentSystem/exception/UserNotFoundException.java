/**
 * 
 */
package com.ing.bookManagmentSystem.exception;

/**
 * @author srinivas
 * used to send UserNotFoundException
 */
public class UserNotFoundException extends RuntimeException {

	/**
	 *  default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param arg0
	 */
	public UserNotFoundException(String arg0) {
		super(arg0);
	}

}
