/**
 * 
 */
package com.ing.bookManagmentSystem.exception;

/**
 * @author srinivas
 *
 */
public class BookNotFoundException extends RuntimeException {

	/**
	 * serial version uid
	 */
	private static final long serialVersionUID = 1L;

	public BookNotFoundException(String message) {
		super(message);
	}
	
	

}
