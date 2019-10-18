package com.ing.bookManagmentSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ing.bookManagmentSystem.dto.BorrowBookDto;
import com.ing.bookManagmentSystem.dto.BorrowBookResponseDto;
import com.ing.bookManagmentSystem.dto.CategoryDto;
import com.ing.bookManagmentSystem.dto.CategoryListDto;
import com.ing.bookManagmentSystem.dto.CompleteBookDto;
import com.ing.bookManagmentSystem.entity.Book;
import com.ing.bookManagmentSystem.service.BookService;
import com.ing.bookManagmentSystem.util.ExceptionConstants;

/**
 * 
 * @author Sharath G S
 * @apiNote test classes for the book controller
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class BookControllerTest {

	
	@Mock
	BookService bookService;
	
	@InjectMocks
	BookController bookController;
	
	BorrowBookResponseDto borrowBookResponse = null;
	BorrowBookDto borrowBook = null;
	Book book2 = null;
	Book book1 = null;
	CompleteBookDto completeBook = null;
	List<Book> bookList = null;
	CategoryDto categoryDto = null;
	CategoryListDto categorys = null;
	CategoryListDto categorys1 = null;
	List<CategoryListDto> categoryListDto = null;
	
	@Before
	public void setUp()
	{
		
		borrowBookResponse = new BorrowBookResponseDto();
		borrowBookResponse.setMessage(ExceptionConstants.BORROW_BOOKS);
		borrowBookResponse.setStatusCode(ExceptionConstants.SUCCESS);
		
		borrowBook = new BorrowBookDto();
		borrowBook.setBookId(1);
		borrowBook.setUserId(1);
		
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
		
		bookList = new ArrayList<>();
		bookList.add(book1);
		bookList.add(book2);
		
		completeBook = new CompleteBookDto();
		completeBook.setMessage(ExceptionConstants.BOOK_LIST);
		completeBook.setStatusCode(ExceptionConstants.SUCCESS);
		
		categorys = new CategoryListDto();
		categorys.setCategory("HISTORY");
		
		categorys1 = new CategoryListDto();
		categorys1.setCategory("SCIENCE");
		
		categoryListDto = new ArrayList<>();
		categoryListDto.add(categorys);
		categoryListDto.add(categorys1);
		
		categoryDto = new CategoryDto();
		categoryDto.setMessage(ExceptionConstants.CATEGORY_LIST);
		categoryDto.setStatusCode(ExceptionConstants.SUCCESS);
		categoryDto.setCategory(categoryListDto);
	}
	
	@Test
	public void borrowBookTest()
	{
		
		Mockito.when(bookService.borrowBook(borrowBook)).thenReturn(borrowBookResponse);
		ResponseEntity<BorrowBookResponseDto> responseEntity = bookController.borrowBook(borrowBook);
		BorrowBookResponseDto borrowBook = responseEntity.getBody();
		Assert.assertEquals(borrowBook.getMessage(), borrowBookResponse.getMessage());
	}
	
	@Test
	public void bookListTest()
	{
		Mockito.when(bookService.getBooksList(Mockito.anyInt())).thenReturn(completeBook);
		ResponseEntity<CompleteBookDto> responseEntity = bookController.getBooksDetails(Mockito.anyInt());
		CompleteBookDto completeBooks = responseEntity.getBody();
		Assert.assertEquals(completeBooks.getMessage(), completeBook.getMessage());
	}
	
	@Test
	public void bookCategoryTest()
	{
		Mockito.when(bookService.category()).thenReturn(categoryDto);
		ResponseEntity<CategoryDto> responseEntity = bookController.category();
		CategoryDto categorysListDto = responseEntity.getBody();
		Assert.assertEquals(categorysListDto.getMessage(), categoryDto.getMessage());
	}
}
