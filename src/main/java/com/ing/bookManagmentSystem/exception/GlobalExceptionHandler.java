package com.ing.bookManagmentSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * @author User1
 * Used to throw global exceptions
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * @param Exception
	 * @return ResponseEntity
	 */
	@ExceptionHandler(CommonException.class)
	public ResponseEntity<ResponseError> commonException(Exception e) {
		ResponseError error = new ResponseError(e.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
	/**
	 * @param exception
	 * @param request
	 * @return ResponseEntity
	 */
	@ExceptionHandler(UserExistException.class)
	public ResponseEntity<ResponseError> globalExceptionHandler(UserExistException exception, WebRequest request) {
		ResponseError errorResponse = new ResponseError();
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	/**
	 * @param BookExistsException
	 * @return ResponseEntity
	 */
	@ExceptionHandler(BookExistsException.class)
	public ResponseEntity<ResponseError> bookExistsException(BookExistsException e) {
		ResponseError error = new ResponseError(e.getMessage(), HttpStatus.FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.FOUND);
	}

	/**
	 * @param BorrowedBooksNotExistsException
	 * @return ResponseEntity
	 */
	@ExceptionHandler(BorrowedBooksNotExistsException.class)
	public ResponseEntity<ResponseError> borrowedBooksNotExistsException(BorrowedBooksNotExistsException e) {
		ResponseError error = new ResponseError(e.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	/**
	 * @param BookNotFoundException
	 * @return ResponseEntity
	 */
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ResponseError> bookNotFoundException(BookNotFoundException e) {
		ResponseError error = new ResponseError(e.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
