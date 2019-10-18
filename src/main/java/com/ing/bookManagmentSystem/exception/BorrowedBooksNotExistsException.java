/**
 * 
 */
package com.ing.bookManagmentSystem.exception;

/**
 * @author srinivas
 * Used to send BorrowedBooksNotExistsException
 */
public class BorrowedBooksNotExistsException extends RuntimeException {

	/**
	 * serial version uid
	 */
	private static final long serialVersionUID = 1L;

	public BorrowedBooksNotExistsException(String message) {
		super(message);
	}

}
