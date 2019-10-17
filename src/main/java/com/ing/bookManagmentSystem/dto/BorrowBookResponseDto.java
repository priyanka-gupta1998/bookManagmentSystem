package com.ing.bookManagmentSystem.dto;

import java.time.LocalDate;
import java.util.Date;

public class BorrowBookResponseDto {

	private String message; 
	private int statusCode;
	private int borrowedId;
	private LocalDate borrowedEndDate;
	
	public LocalDate getBorrowedEndDate() {
		return borrowedEndDate;
	}
	public void setBorrowedEndDate(LocalDate borrowedEndDate) {
		this.borrowedEndDate = borrowedEndDate;
	}
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
	public int getBorrowedId() {
		return borrowedId;
	}
	public void setBorrowedId(int borrowedId) {
		this.borrowedId = borrowedId;
	}
}
