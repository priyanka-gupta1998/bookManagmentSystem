package com.ing.bookManagmentSystem.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ing.bookManagmentSystem.controller.LoginController;
import com.ing.bookManagmentSystem.dto.BookDto;
import com.ing.bookManagmentSystem.dto.BorrowBookDto;
import com.ing.bookManagmentSystem.dto.BorrowBookResponseDto;
import com.ing.bookManagmentSystem.dto.CategoryBookResponseDto;
import com.ing.bookManagmentSystem.dto.CategoryDto;
import com.ing.bookManagmentSystem.dto.CategoryListDto;
import com.ing.bookManagmentSystem.dto.CompleteBookDto;
import com.ing.bookManagmentSystem.entity.Book;
import com.ing.bookManagmentSystem.entity.BorrowedBooks;
import com.ing.bookManagmentSystem.repository.BookRepository;
import com.ing.bookManagmentSystem.repository.BorrowedBooksRepository;
import com.ing.bookManagmentSystem.repository.UserRepository;
import com.ing.bookManagmentSystem.util.BookUtil;
import com.ing.bookManagmentSystem.util.ExceptionConstants;
/**
 * 
 * @author Sharath G S
 * @apiNote Book service implementation
 *
 */
@Service
public class BookServiceImpl implements BookService {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	BorrowedBooksRepository borrowedBookRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BookUtil bookUtil;
	
	@Value("${book.lend}")
	private int bookEndDays;
	
	/**
	 * @author Sharath G S
	 * @apiNote list of books by search
	 * @return list of books
	 */
	@Override
	public CategoryBookResponseDto getBooks(String category) {

		LOGGER.info("events for service for book category search called");
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
		
		LOGGER.info("events for service for book borrow called or insertion to borrow");
		BorrowBookResponseDto borrowResponse = new BorrowBookResponseDto();
		Optional<Book> bookData = bookRepository.findBybookId(borrowBookDto.getBookId());
		
		
		bookData.ifPresent(book -> {
			 userRepository.findById(borrowBookDto.getUserId()).ifPresent(user ->{ 
				 
				 BorrowedBooks borrowBook = new BorrowedBooks();
				 
				borrowBook.setBook(book);
				borrowBook.setUser(user);
				borrowBook.setBorrowedStartDate(LocalDate.now());
				borrowBook.setBorrowedEndDate(LocalDate.now().plusDays(bookEndDays));
				borrowedBookRepository.save(borrowBook);
				
				book.setBookStatus(ExceptionConstants.NOT_AVAILABLE);
				bookRepository.save(book);
				borrowResponse.setBorrowedEndDate(LocalDate.now().plusDays(bookEndDays));
				borrowResponse.setMessage(ExceptionConstants.BORROW_BOOKS);
				borrowResponse.setStatusCode(ExceptionConstants.SUCCESS);
				
			 });
		});
		
		return borrowResponse;
	}


	/**
	 * @author Sharath GS 
	 * @apiNote get List of books
	 * @param userId
	 * @return list of books
	 */
	public CompleteBookDto getBooksList(int userId) {
		
		LOGGER.info("events for book list service");
		CompleteBookDto completeBook = new CompleteBookDto();
		List<Book> bookList = bookRepository.findAll();
		List<BookDto> bookListDto = new ArrayList<>();
		bookList.stream().forEach(book ->{
			BookDto bookDto = new BookDto();
			BeanUtils.copyProperties(book, bookDto);
			bookListDto.add(bookDto);
		});
		completeBook.setBooks(bookListDto);
		completeBook.setMessage(ExceptionConstants.BOOK_LIST);
		completeBook.setStatusCode(ExceptionConstants.SUCCESS);
		return completeBook;
	}
	
	/**
	 * @author Sharath G S
	 * @apiNote list of category
	 * @return category list
	 */
	public CategoryDto category()
	{
		LOGGER.info("events for service for category list");
		CategoryDto category = new CategoryDto();
		
		List<Book> books = bookRepository.findAll().stream().filter(bookUtil.distinctByKey(book -> book.getBookCategory())).collect(Collectors.toList());
		List<CategoryListDto> categoryDto = new ArrayList<>();
		
		books.stream().forEach(bookDto ->{
			CategoryListDto categorys = new CategoryListDto();
			categorys.setCategory(bookDto.getBookCategory());
			categoryDto.add(categorys);
		});
		
		category.setCategory(categoryDto);
		category.setMessage(ExceptionConstants.CATEGORY_LIST);
		category.setStatusCode(ExceptionConstants.SUCCESS);
		return category;
	}

}
