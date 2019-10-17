/**
 * 
 */
package com.ing.bookManagmentSystem.scheduler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ing.bookManagmentSystem.constants.BookManagementConstants;
import com.ing.bookManagmentSystem.entity.Book;
import com.ing.bookManagmentSystem.entity.BorrowedBooks;
import com.ing.bookManagmentSystem.exception.BookNotFoundException;
import com.ing.bookManagmentSystem.exception.BorrowedBooksNotExistsException;
import com.ing.bookManagmentSystem.repository.BookRepository;
import com.ing.bookManagmentSystem.repository.BorrowedBooksRepository;

/**
 * @author Srinivas 
 * To change the status of avialable books
 */
@Component
public class BookStatusChangeScheduler {
	private static final Logger LOGGER = LoggerFactory.getLogger(BookStatusChangeScheduler.class);
	@Autowired
	BookRepository bookRepository;

	@Autowired
	BorrowedBooksRepository borrowedBooksRepository;

	/**
	 * it will run everyday 6 O'clock 
	 * To change the status of avialable books
	 */
//	@Scheduled(cron = "0 0 6 * * *")
	@Scheduled(fixedRate = 5000)
	public void cronJobSch() throws Exception {
		
		LocalDate now2 = LocalDate.now();
		LOGGER.info("localDate: "+now2);
		Optional<List<BorrowedBooks>> findByBorrowedEndDate = borrowedBooksRepository.findByBorrowedEndDate(now2);
		if (!findByBorrowedEndDate.isPresent()) {
			throw new BorrowedBooksNotExistsException(BookManagementConstants.B_BOOKS_NOT_FOUND);
		}
		List<BorrowedBooks> borrowedBookslist = findByBorrowedEndDate.get();
		List<Book> booksList = new ArrayList<Book>();
		borrowedBookslist.forEach(borrowedBook -> {
			Optional<BorrowedBooks> findByBookBookId = borrowedBooksRepository
					.findByBookBookId(borrowedBook.getBook().getBookId());
			Integer bookId = findByBookBookId.get().getBook().getBookId();
			Optional<Book> findById = bookRepository.findById(bookId);
			if (!findById.isPresent()) {
				throw new BookNotFoundException(BookManagementConstants.BOOK_NOT_FOUND);
			}
			Book book = findById.get();
			book.setBookStatus(BookManagementConstants.BOOK_STATUS);
			booksList.add(book);
		});
		bookRepository.saveAll(booksList);
	}

}
