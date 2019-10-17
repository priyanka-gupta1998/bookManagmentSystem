package com.ing.bookManagmentSystem.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.bookManagmentSystem.dto.DonateBookRequestDTO;
import com.ing.bookManagmentSystem.dto.DonateBookResponseDTO;
import com.ing.bookManagmentSystem.entity.Book;
import com.ing.bookManagmentSystem.service.DonateBookService;

@RunWith(MockitoJUnitRunner.class)
public class DonateBookControllerTest {

	@InjectMocks
	DonateBookController donateBookController;

	@Mock
	private DonateBookService donateBookService;

	@Test
	public void addBookTest() {
		Book book = new Book();
		book.setBookId(1);
		book.setBookName("book1");
		book.setBookAuthor("author");
		book.setBookPublisher("us");
		book.setBookCategory("horror");
		book.setBookStatus("available");
		book.setDescription("horror stories");
		Mockito.when(donateBookService.addBook(Mockito.any())).thenReturn(book);
		DonateBookRequestDTO donateBook = new DonateBookRequestDTO();
		donateBook.setBookAuthor("sdhfwdg");
		donateBook.setBookName("book1");
		donateBook.setBookAuthor("author");
		donateBook.setBookPublisher("us");
		donateBook.setBookCategory("horror");
		donateBook.setBookStatus("available");
		donateBook.setDescription("horror stories");
		DonateBookResponseDTO addBook = donateBookController.addBook(donateBook);
		assertNotNull(addBook);
	}
}
