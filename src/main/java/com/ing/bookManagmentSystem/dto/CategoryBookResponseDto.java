package com.ing.bookManagmentSystem.dto;

import java.util.List;

public class CategoryBookResponseDto {

	
	private String message; 
	private int statusCode;
	private List<BookDto> data;
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
	public List<BookDto> getData() {
		return data;
	}
	public void setData(List<BookDto> data) {
		this.data = data;
	}
}
