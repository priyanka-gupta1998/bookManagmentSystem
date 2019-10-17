package com.ing.bookManagmentSystem.dto;

import java.time.LocalDate;

public class RequestResponseDto {
	
	private LocalDate endDate;
	private String message;
	private Integer statusCode;
	
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
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
	
	
}
