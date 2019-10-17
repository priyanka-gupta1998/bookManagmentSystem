/**
 * 
 */
package com.ing.bookManagmentSystem.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bookManagmentSystem.constants.BookManagementConstants;
import com.ing.bookManagmentSystem.dto.DonateBookRequestDTO;
import com.ing.bookManagmentSystem.dto.DonateBookResponseDTO;
import com.ing.bookManagmentSystem.entity.Book;
import com.ing.bookManagmentSystem.exception.BookExistsException;
import com.ing.bookManagmentSystem.repository.BookRepository;
import com.ing.bookManagmentSystem.scheduler.BookStatusChangeScheduler;

/**
 * @author SRINIVAS P
 *
 */
@Service
public class DonateBookServiceImpl implements DonateBookService {
	private static final Logger LOGGER = LoggerFactory.getLogger(BookStatusChangeScheduler.class);
	@Autowired
	BookRepository bookRepository;
	/**
	 * @param DonateBookRequestDTO
	 * @return DonateBookResponseDTO
	 */
	@Override
	public DonateBookResponseDTO addBook(DonateBookRequestDTO donateBook) {
		LOGGER.info("entered into addBook method of DonateBookServiceImpl class");
		Book book = new Book();
		BeanUtils.copyProperties(donateBook, book);
		Optional<Book> optionalBook = bookRepository.findByBookName(book.getBookName());
		if (optionalBook.isPresent()) {
			throw new BookExistsException(BookManagementConstants.BOOK_EXISTS_EXCEPTION);
		}
		bookRepository.save(book);
		DonateBookResponseDTO donateBookResponseDTO = new DonateBookResponseDTO();
		donateBookResponseDTO.setMessage(BookManagementConstants.DONATEBOOK_POST_STATUS_MSG);
		donateBookResponseDTO.setStatusCode(BookManagementConstants.DONATEBOOK_POST_STATUS_CODE);

		return donateBookResponseDTO;
	}

}
