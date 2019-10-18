/**
 * 
 */
package com.ing.bookManagmentSystem.exception;

/**
 * @author srinivas 
 * Used to send BookExistsException
 */
public class BookExistsException extends RuntimeException {

	/**
	 * serial version uid
	 */
	private static final long serialVersionUID = 1L;

	public BookExistsException(String arg0) {
		super(arg0);
	}

}
