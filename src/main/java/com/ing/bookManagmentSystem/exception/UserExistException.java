package com.ing.bookManagmentSystem.exception;

public class UserExistException extends RuntimeException
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private int statusCode;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public UserExistException(String message, int statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}
	
	
}
