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

import com.ing.bookManagmentSystem.dto.DonateBookRequestDTO;
import com.ing.bookManagmentSystem.dto.DonateBookResponseDTO;
import com.ing.bookManagmentSystem.scheduler.BookStatusChangeScheduler;
import com.ing.bookManagmentSystem.service.DonateBookService;

/**
 * @author srinivas
 *
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
	 */
	@PostMapping("/add")
	public DonateBookResponseDTO addBook(@RequestBody DonateBookRequestDTO donateBook) {
		LOGGER.info("entered into DonateBookController");
		return donateBookService.addBook(donateBook);
	}

}
