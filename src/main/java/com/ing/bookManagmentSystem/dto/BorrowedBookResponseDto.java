package com.ing.bookManagmentSystem.dto;

import java.util.List;

public class BorrowedBookResponseDto {
	private List<RequestBorrowedBooksDetailsDto> borrowedBookDetails;
	private String message;
	private Integer statusCode;
	
	

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
	
}
