package com.ing.bookManagmentSystem.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ing.bookManagmentSystem.service.BookService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
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
}