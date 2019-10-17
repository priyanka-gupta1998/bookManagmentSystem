package com.ing.bookManagmentSystem.service;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.ing.bookManagmentSystem.dto.DonateBookRequestDTO;
import com.ing.bookManagmentSystem.entity.Book;
import com.ing.bookManagmentSystem.repository.BookRepository;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DonateBookServiceImplTest {

	@Mock
	BookRepository bookRepository;

	DonateBookServiceImpl donateBookServiceImpl;

	@Test
	public void testFundsTransfer() {

		DonateBookRequestDTO donateBook = new DonateBookRequestDTO();
		donateBook.setBookName("book1");
		donateBook.setBookAuthor("author");
		donateBook.setBookCategory("horror");
		donateBook.setBookPublisher("us");
		donateBook.setBookStatus("available");
		donateBook.setDescription("horror stories");
		// donateBook.setDonatedDate("");
		donateBook.setUserId(1);
		Book book = new Book();
		book.setBookName("book1");
		BeanUtils.copyProperties(donateBook, book);

		Optional<Book> optionalBook = Optional.of(book);

		Mockito.when(bookRepository.findByBookName("book1")).thenReturn(optionalBook);
		Mockito.when(bookRepository.save(book)).thenReturn(book);
		Book addBook = donateBookServiceImpl.addBook(donateBook);

		Assert.assertNotNull(addBook);

	}
}
