package com.ing.bookManagmentSystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.bookManagmentSystem.dto.BorrowedBookResponseDto;
import com.ing.bookManagmentSystem.dto.RequestResponseDto;
import com.ing.bookManagmentSystem.exception.CommonException;
import com.ing.bookManagmentSystem.service.BorrowedService;
import com.ing.bookManagmentSystem.util.ExceptionConstants;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/books")
public class BorrowedBooksController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BorrowedBooksController.class);
	@Autowired
	BorrowedService borrowedService;

	/**
	 * @author Priyanka Gupta
	 * @apiNote controller for borrowed books
	 * @return list of borrowed books details
	 */
	@GetMapping("/{userId}")
	public BorrowedBookResponseDto borrowedDeatails(@PathVariable("userId") Integer userId) {
		LOGGER.info("Borrowed Books Controller");
		BorrowedBookResponseDto borrowedBookResponseDto = borrowedService.borrowedDetails(userId);
		if (borrowedBookResponseDto != null) {
			borrowedBookResponseDto.setStatusCode(201);
			borrowedBookResponseDto.setMessage("Borrowed Details !!!");
			return borrowedBookResponseDto;

		}

		else {
			throw new CommonException(ExceptionConstants.BOOK_NOT_FOUND);
		}

	}

	/**
	 * @author Abhishek C
	 * @apiNote controller for borrowed books
	 * @Param bookId
	 * @return book end date
	 * @Throws
	 */
	@GetMapping("availability/{bookId}")
	public RequestResponseDto requestEndDate(@PathVariable("bookId") Integer bookId) {
		LOGGER.info("Borrowed Books Controller");
		RequestResponseDto response = borrowedService.requestEndDate(bookId);
		response.setStatusCode(201);
		response.setMessage("Borrowed Details !!!");
		return response;
	}

}
