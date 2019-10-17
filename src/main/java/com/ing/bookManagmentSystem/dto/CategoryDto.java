package com.ing.bookManagmentSystem.dto;

import java.util.List;

public class CategoryDto {

	private String message;
	private int statusCode;
	private List<CategoryListDto> category;
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
	public List<CategoryListDto> getCategory() {
		return category;
	}
	public void setCategory(List<CategoryListDto> category) {
		this.category = category;
	}
	
	
}
