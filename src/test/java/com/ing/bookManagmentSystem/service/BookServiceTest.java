package com.ing.bookManagmentSystem.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.bookManagmentSystem.entity.Book;
import com.ing.bookManagmentSystem.repository.BookRepository;
import com.ing.bookManagmentSystem.repository.BorrowedBooksRepository;
import com.ing.bookManagmentSystem.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
	
	@Mock
	BookRepository bookRepository;
	
	@Mock
	BorrowedBooksRepository borrowedBookRepository;
	
	@Mock
	UserRepository userRepository;
	
	Book book1 = null;
	
	@Before
	public void setUp()
	{
		book1 = new Book();
		book1.setBookAuthor("Test");
		book1.setBookCategory("SCIENCE");
		book1.setBookId(1);
	}
	
	@Test
	public void getBooksTest()
	{
		
	}

}
