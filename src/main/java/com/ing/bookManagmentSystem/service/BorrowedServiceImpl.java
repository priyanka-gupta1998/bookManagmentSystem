package com.ing.bookManagmentSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bookManagmentSystem.dto.BorrowedBookResponseDto;
import com.ing.bookManagmentSystem.dto.RequestBorrowedBooksDetailsDto;
import com.ing.bookManagmentSystem.dto.RequestResponseDto;
import com.ing.bookManagmentSystem.entity.BorrowedBooks;
import com.ing.bookManagmentSystem.exception.CommonException;
import com.ing.bookManagmentSystem.repository.BorrowedBooksRepository;
import com.ing.bookManagmentSystem.util.ExceptionConstants;

@Service
public class BorrowedServiceImpl implements BorrowedService {
	private static final Logger LOGGER = LoggerFactory.getLogger(BorrowedServiceImpl.class);
	@Autowired
	BorrowedBooksRepository borrowedBooksRepository;

	/**
	 * @author Priyanka Gupta
	 * @apiNote userId we need to pass
	 * @return list of borrowedBooks
	 */

	public BorrowedBookResponseDto borrowedDetails(Integer userId) {

		LOGGER.info("User Login");
		List<RequestBorrowedBooksDetailsDto> requestBorrowedBooksDetails = new ArrayList<>();

		Optional<List<BorrowedBooks>> borrowedBookDetail = borrowedBooksRepository.findAllById(userId);
		List<BorrowedBooks> borrowedBooks = borrowedBookDetail.get();
		borrowedBooks.stream().forEach(borrowedBookDetails -> {

			RequestBorrowedBooksDetailsDto requestBorrowedBooksDetailsDto = new RequestBorrowedBooksDetailsDto();
			requestBorrowedBooksDetailsDto.setBookName(borrowedBookDetails.getBook().getBookName());
			requestBorrowedBooksDetailsDto.setBorrowedStartDate(borrowedBookDetails.getBorrowedStartDate());
			requestBorrowedBooksDetailsDto.setBorrowedEndDate(borrowedBookDetails.getBorrowedEndDate());
			requestBorrowedBooksDetails.add(requestBorrowedBooksDetailsDto);
		});

		BorrowedBookResponseDto borrowedBookResponseDto = new BorrowedBookResponseDto();
		borrowedBookResponseDto.setBorrowedBookDetails(requestBorrowedBooksDetails);
		return borrowedBookResponseDto;
	}

	/**
	 * @author Abhishek C
	 * @apiNote controller for borrowed books
	 * @Param bookId
	 * @return book end date
	 * @Throws
	 */
	public RequestResponseDto requestEndDate(Integer bookId) {
		LOGGER.info("request for book end date");
		RequestResponseDto response = new RequestResponseDto();
		Optional<BorrowedBooks> borrowedBook = borrowedBooksRepository.findByBookBookId(bookId);
		if (!borrowedBook.isPresent()) {
			throw new CommonException(ExceptionConstants.BOOK_NOT_FOUND);
		}
		response.setEndDate(borrowedBook.get().getBorrowedEndDate());
		return response;

	}
}
