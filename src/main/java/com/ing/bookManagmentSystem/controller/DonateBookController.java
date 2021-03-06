/**
 * 
 */
package com.ing.bookManagmentSystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.bookManagmentSystem.constants.BookManagementConstants;
import com.ing.bookManagmentSystem.dto.DonateBookRequestDTO;
import com.ing.bookManagmentSystem.dto.DonateBookResponseDTO;
import com.ing.bookManagmentSystem.entity.Book;
import com.ing.bookManagmentSystem.scheduler.BookStatusChangeScheduler;
import com.ing.bookManagmentSystem.service.DonateBookService;

/**
 * @author srinivas
 * This class is used to Donate a Book to library
 */
@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/books")
public class DonateBookController {
	private static final Logger LOGGER = LoggerFactory.getLogger(BookStatusChangeScheduler.class);
	@Autowired
	private DonateBookService donateBookService;
	/**
	 * @param DonateBookRequestDTO
	 * @return DonateBookResponseDTO
	 * Used to add a book to library
	 */
	@PostMapping("/add")
	public DonateBookResponseDTO addBook(@RequestBody DonateBookRequestDTO donateBook) {
		LOGGER.info("entered into DonateBookController");
		Book addBook = donateBookService.addBook(donateBook);
		DonateBookResponseDTO donateBookResponseDTO = new DonateBookResponseDTO();
		donateBookResponseDTO.setBookId(addBook.getBookId());
		donateBookResponseDTO.setMessage(BookManagementConstants.DONATEBOOK_POST_STATUS_MSG);
		donateBookResponseDTO.setStatusCode(BookManagementConstants.DONATEBOOK_POST_STATUS_CODE);
		return donateBookResponseDTO;
	}

}
