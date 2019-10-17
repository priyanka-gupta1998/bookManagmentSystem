package com.ing.bookManagmentSystem.service;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.bookManagmentSystem.dto.DonateBookRequestDTO;
import com.ing.bookManagmentSystem.entity.Book;
import com.ing.bookManagmentSystem.entity.User;
import com.ing.bookManagmentSystem.repository.BookRepository;
import com.ing.bookManagmentSystem.repository.UserRepository;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.Silent.class)
public class DonateBookServiceImplTest {

	@Mock
	BookRepository bookRepository;
	@Mock
	UserRepository userRepository;
	@InjectMocks
	DonateBookServiceImpl donateBookServiceImpl;

	@Test
	public void testFundsTransfer() {

		DonateBookRequestDTO donateBook = new DonateBookRequestDTO();
		donateBook.setBookName("book2");
		donateBook.setBookAuthor("author");
		donateBook.setBookCategory("horror");
		donateBook.setBookPublisher("us");
		donateBook.setBookStatus("available");
		donateBook.setDescription("horror stories");

		User user = new User();
		user.setUserId(1);
		user.setEmailId("sdvgd");
		user.setFirstName("shcgsdh");
		user.setLastName("sdfgwdjh");
		user.setPassword("dfh");
		user.setPhoneNo(536);

		Book book = new Book();
		book.setBookId(1);
		book.setBookName("book1");
		book.setBookAuthor("author");
		book.setBookPublisher("us");
		book.setBookCategory("horror");
		book.setBookStatus("available");
		book.setDescription("horror stories");
		book.setUser(user);

		Mockito.when(bookRepository.findByBookName(book.getBookName())).thenReturn(Optional.ofNullable(book));
		Mockito.when(bookRepository.save(Mockito.any())).thenReturn(book);
		Book addBook = donateBookServiceImpl.addBook(donateBook);
		Assert.assertNotNull(addBook);
		Assert.assertEquals(book.getBookName(), addBook.getBookName());

	}
}
