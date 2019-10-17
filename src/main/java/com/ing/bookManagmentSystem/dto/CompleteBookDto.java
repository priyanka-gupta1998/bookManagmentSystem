package com.ing.bookManagmentSystem.dto;

import java.util.List;

public class CompleteBookDto {

	private String message;
	private int statusCode;
	private List<BookDto> books;
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
	public List<BookDto> getBooks() {
		return books;
	}
	public void setBooks(List<BookDto> books) {
		this.books = books;
	}
	
}
