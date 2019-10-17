package com.ing.bookManagmentSystem.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ing.bookManagmentSystem.dto.BorrowBookDto;
import com.ing.bookManagmentSystem.dto.BorrowBookResponseDto;
import com.ing.bookManagmentSystem.dto.CategoryDto;
import com.ing.bookManagmentSystem.dto.CompleteBookDto;
import com.ing.bookManagmentSystem.service.BookService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class BookController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	BookService bookService;
	
	/**
	 * @author Sharath G S
	 * @apiNote controller for search
	 * @return list of books
	 */
	@GetMapping("/categorys/{category}/books")
	public ResponseEntity search(@PathVariable String category)
	{
		LOGGER.info("controller for book search by category called");
		return new ResponseEntity(bookService.getBooks(category),HttpStatus.OK);
	}
	
	/**
	 * @author Sharath G S
	 * @param borrowBookDto
	 * @apiNote borrow book
	 * @return borrowed books
	 */
	@PostMapping("/books/borrow")
	public ResponseEntity<BorrowBookResponseDto> borrowBook(@RequestBody BorrowBookDto borrowBookDto)
	{
		LOGGER.info("controller for books borrow called");
		return new ResponseEntity(bookService.borrowBook(borrowBookDto),HttpStatus.OK);
	}
	
	/**
	 * @author Sharath G S
	 * @param userId
	 * @apiNote list of books
	 * @return books list
	 */
	@GetMapping("/books/users/{userId}")
	public ResponseEntity<CompleteBookDto> getBooksDetails(@PathVariable int userId)
	{
		LOGGER.info("controller for list of books");
		return new ResponseEntity(bookService.getBooksList(userId),HttpStatus.OK);
	}
	
	/**
	 * @author Sharath G S
	 * @apiNote list of category
	 * @return list of category
	 */
	@GetMapping("/books/category")
	public ResponseEntity<CategoryDto> category()
	{
		LOGGER.info("controller for list of category");
		return new ResponseEntity(bookService.category(),HttpStatus.OK);
	}
}
