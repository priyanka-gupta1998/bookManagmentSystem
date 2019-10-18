package com.ing.bookManagmentSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.ing.bookManagmentSystem.dto.BorrowBookDto;
import com.ing.bookManagmentSystem.dto.BorrowBookResponseDto;
import com.ing.bookManagmentSystem.dto.CategoryBookResponseDto;
import com.ing.bookManagmentSystem.dto.CompleteBookDto;
import com.ing.bookManagmentSystem.entity.Book;
import com.ing.bookManagmentSystem.entity.BorrowedBooks;
import com.ing.bookManagmentSystem.entity.User;
import com.ing.bookManagmentSystem.repository.BookRepository;
import com.ing.bookManagmentSystem.repository.BorrowedBooksRepository;
import com.ing.bookManagmentSystem.repository.UserRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BookServiceTest {
	
	@Mock
	BookRepository bookRepository;
	
	@Mock
	BorrowedBooksRepository borrowedBookRepository;
	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	BookServiceImpl bookService;
	
	Book book1 = null;
	Book book2 = null;
	User user1 = null;
	BorrowedBooks borrow = null;
	BorrowBookDto borrowDto = null;
	
	@Before
	public void setUp()
	{
		book1 = new Book();
		book1.setBookAuthor("Kuvempu");
		book1.setBookCategory("Drama");
		book1.setBookId(1);
		book1.setBookName("Ramayana");
		book1.setBookPublisher("Peterson");
		book1.setBookStatus("AVAILABLE");
		book1.setDescription("kuvempu greatest epic");
		
		book2 = new Book();
		book2.setBookAuthor("Test");
		book2.setBookCategory("SCIENCE");
		book2.setBookId(2);
		book2.setBookName("Incests");
		book2.setBookPublisher("Oxford");
		book2.setBookStatus("NOT AVAILABLE");
		book2.setDescription("about insects");
		
		user1 = new User();
		user1.setEmailId("sharathgs777@gmail.com");
		user1.setFirstName("Shar");
		user1.setLastName("G S");
		user1.setPassword("test@123");
		user1.setPhoneNo(1234567890);
		user1.setUserId(1);
		
		borrow = new BorrowedBooks();
		borrow.setBook(book1);
		borrow.setUser(user1);
		borrow.setBorrowedId(1);
		
		borrowDto = new BorrowBookDto();
		borrowDto.setBookId(book1.getBookId());
		borrowDto.setUserId(user1.getUserId());
	}
	
	@Test
	public void getBooksTest()
	{
		List<Book> books = new ArrayList<>();
		books.add(book1);
		books.add(book2);
		Mockito.when(bookRepository.findAll()).thenReturn(books);
		CompleteBookDto completeDto = bookService.getBooksList(1);
		Assert.assertEquals(completeDto.getStatusCode(), HttpStatus.OK.value());
	}
	
	@Test
	public void searchBooksByCategory()
	{
		List<Book> books = new ArrayList<>();
		books.add(book2);
		Mockito.when(bookRepository.findAllBybookCategory(book2.getBookCategory())).thenReturn(books);
		CategoryBookResponseDto categoryBook = bookService.getBooks(book2.getBookCategory());
		Assert.assertEquals(categoryBook.getStatusCode(), HttpStatus.OK.value());
	}
	
	@Test
	public void borrowBook()
	{
		Mockito.when(bookRepository.findBybookId(book1.getBookId())).thenReturn(Optional.of(book1));
		Mockito.when(userRepository.findById(user1.getUserId())).thenReturn(Optional.of(user1));
		Mockito.when(borrowedBookRepository.save(borrow)).thenReturn(borrow);
		BorrowBookResponseDto borrowResponse =bookService.borrowBook(borrowDto);
		Assert.assertEquals(borrowResponse.getStatusCode(), HttpStatus.OK.value());
	}

}
