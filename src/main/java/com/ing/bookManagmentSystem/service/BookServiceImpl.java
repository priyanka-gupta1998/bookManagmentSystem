package com.ing.bookManagmentSystem.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bookManagmentSystem.controller.LoginController;
import com.ing.bookManagmentSystem.dto.BookDto;
import com.ing.bookManagmentSystem.dto.BorrowBookDto;
import com.ing.bookManagmentSystem.dto.BorrowBookResponseDto;
import com.ing.bookManagmentSystem.dto.CategoryBookResponseDto;
import com.ing.bookManagmentSystem.entity.Book;
import com.ing.bookManagmentSystem.entity.BorrowedBooks;
import com.ing.bookManagmentSystem.repository.BookRepository;
import com.ing.bookManagmentSystem.repository.BorrowedBooksRepository;
import com.ing.bookManagmentSystem.repository.UserRepository;
import com.ing.bookManagmentSystem.util.ExceptionConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookServiceImpl implements BookService {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	BorrowedBooksRepository borrowedBookRepository;
	
	@Autowired
	UserRepository userRepository;
	
	/**
	 * @author Sharath G S
	 * @apiNote list of books by search
	 * @return list of books
	 */
	@Override
	public CategoryBookResponseDto getBooks(String category) {

		log.info("events for service for book category search called");
		List<Book> books = bookRepository.findAllBybookCategory(category);

		List<BookDto> booksDto = new ArrayList<>();
		CategoryBookResponseDto categoryBook = new CategoryBookResponseDto();
		
		books.stream().forEach(book -> {
			BookDto bookDto = new BookDto();
			BeanUtils.copyProperties(book, bookDto);
			booksDto.add(bookDto);
		});
		categoryBook.setData(booksDto);
		categoryBook.setStatusCode(ExceptionConstants.SUCCESS);
		categoryBook.setMessage(ExceptionConstants.CATEGORY_BOOK);
		return categoryBook;
	}

	
	/**
	 * @author Sharath G S
	 * @apiNote borrow book
	 * @return response success or failure for borrow book
	 */
	@Override
	public BorrowBookResponseDto borrowBook(BorrowBookDto borrowBookDto) {
		// TODO Auto-generated method stub
		
		BorrowBookResponseDto borrowResponse = new BorrowBookResponseDto();
		Optional<Book> bookData = bookRepository.findBybookId(borrowBookDto.getBookId());
		
		
		bookData.ifPresent(book -> {
			 userRepository.findById(borrowBookDto.getUserId()).ifPresent(user ->{ 
				 
				 BorrowedBooks borrowBook = new BorrowedBooks();
				 
				borrowBook.setBook(book);
				borrowBook.setUser(user);
				borrowBook.setBorrowedStartDate(LocalDate.now());
				borrowBook.setBorrowedEndDate(LocalDate.now().plusDays(7));
				borrowedBookRepository.save(borrowBook);
				
				book.setBookStatus(ExceptionConstants.NOT_AVAILABLE);
				bookRepository.save(book);
				borrowResponse.setBorrowedEndDate(LocalDate.now().plusDays(7));
				borrowResponse.setMessage(ExceptionConstants.BORROW_BOOKS);
				borrowResponse.setStatusCode(ExceptionConstants.SUCCESS);
				
			 });;
		});
		
		return borrowResponse;
	}

}
