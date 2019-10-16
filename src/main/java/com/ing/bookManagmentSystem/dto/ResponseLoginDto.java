package com.ing.bookManagmentSystem.dto;

import java.util.List;


public class ResponseLoginDto {

	private Integer userId;
	private String firstName;
	private String lastName;
	private String message;
	private Integer statusCode;
	private List<RequestBorrowedBooksDetailsDto> borrowedBookDetails;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public List<RequestBorrowedBooksDetailsDto> getBorrowedBookDetails() {
		return borrowedBookDetails;
	}
	public void setBorrowedBookDetails(List<RequestBorrowedBooksDetailsDto> borrowedBookDetails) {
		this.borrowedBookDetails = borrowedBookDetails;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	
	
}
