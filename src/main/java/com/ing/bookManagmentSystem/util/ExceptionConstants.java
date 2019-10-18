package com.ing.bookManagmentSystem.util;

import org.springframework.http.HttpStatus;

public class ExceptionConstants {
	
	public static final String USER_NOT_FOUND = "Invalid credentials";
	public static final String ACCOUNT_NOT_FOUND = "No accounts found..";
	public static final String INVALID_CREDENTIALS="UserName and password is incorrect";

	public static final String BOOK_NOT_FOUND = "Book is Not present";

	public static final String USER_CREATION = "User registered succesffully";
	public static final String USER_EXISTS = "User already exists";
	public static final String CATEGORY_BOOK = "Category books exists";
	public static final String BORROW_BOOKS = "Book ordered successfully";
	public static final int SUCCESS = HttpStatus.OK.value();
	public static final String AVAILABLE = "AVAILABLE";
	public static final String NOT_AVAILABLE = "NOT AVAILABLE";
	public static final String BOOK_LIST = "Book List";
	public static final String CATEGORY_LIST = "Category List";
}
