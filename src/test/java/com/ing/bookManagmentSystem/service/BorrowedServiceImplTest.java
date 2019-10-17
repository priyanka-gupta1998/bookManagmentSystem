package com.ing.bookManagmentSystem.service;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.bookManagmentSystem.dto.RequestResponseDto;
import com.ing.bookManagmentSystem.entity.Book;
import com.ing.bookManagmentSystem.entity.BorrowedBooks;
import com.ing.bookManagmentSystem.repository.BorrowedBooksRepository;

@RunWith(MockitoJUnitRunner.class)
public class BorrowedServiceImplTest {

	@InjectMocks
	BorrowedServiceImpl borrowedServiceImpl;

	@Mock
	BorrowedBooksRepository borrowedBooksRepository;

	RequestResponseDto responseDto;
	Book book;
	BorrowedBooks borrowedBooks;
	Optional<BorrowedBooks> borrowBooks;

	@Before
	public void setup() {
		book = new Book();
		book.setBookId(1);
		book.setBookAuthor("abhi");

		borrowedBooks = new BorrowedBooks();
		borrowedBooks.setBook(book);
		borrowedBooks.setBorrowedId(1);
		borrowedBooks.setBorrowedEndDate(LocalDate.now());
		responseDto = new RequestResponseDto();
		responseDto.setEndDate(LocalDate.now());
		borrowBooks = Optional.of(borrowedBooks);
	}

	@Test
	public void borrowedEndTest() {
		Mockito.when(borrowedBooksRepository.findByBookBookId(Mockito.any())).thenReturn(borrowBooks);
		responseDto = borrowedServiceImpl.requestEndDate(Mockito.any());
		assertNotNull(responseDto);
	}
}
