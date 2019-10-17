package com.ing.bookManagmentSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CommonException.class)
	public ResponseEntity<ResponseError> commonException(Exception e) {
		ResponseError error = new ResponseError(e.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(UserExistException.class)
	public ResponseEntity<ResponseError> globalExceptionHandler(UserExistException exception, WebRequest request) {
		ResponseError errorResponse = new ResponseError();
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BookExistsException.class)
	public ResponseEntity<ResponseError> bookExistsException(BookExistsException e) {
		ResponseError error = new ResponseError(e.getMessage(), HttpStatus.FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.FOUND);
	}

	@ExceptionHandler(BorrowedBooksNotExistsException.class)
	public ResponseEntity<ResponseError> borrowedBooksNotExistsException(BorrowedBooksNotExistsException e) {
		ResponseError error = new ResponseError(e.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ResponseError> bookNotFoundException(BookNotFoundException e) {
		ResponseError error = new ResponseError(e.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
