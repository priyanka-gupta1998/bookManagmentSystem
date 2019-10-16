package com.ing.bookManagmentSystem.exception;

import java.io.Serializable;


public class ResponseError implements Serializable {

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


	public ResponseError() {
		super();
	}


	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}


	public ResponseError(String message, int statusCode) {
		this.message = message;
		this.statusCode = statusCode;

	}


	

}
