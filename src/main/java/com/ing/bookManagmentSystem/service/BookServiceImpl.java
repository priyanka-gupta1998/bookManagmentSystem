package com.ing.bookManagmentSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ing.bookManagmentSystem.dto.BookDto;
import com.ing.bookManagmentSystem.dto.CategoryBookResponseDto;
import com.ing.bookManagmentSystem.entity.Book;
import com.ing.bookManagmentSystem.repository.BookRepository;
import com.ing.bookManagmentSystem.util.ExceptionConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookrepository;
	
	/**
	 * @author Sharath G S
	 * @apiNote list of books by search
	 * @return list of books
	 */
	@Override
	public CategoryBookResponseDto getBooks(String category) {
		log.info("events for service for book category search called");
		List<Book> books = bookrepository.findAllBybookCategory(category);
		List<BookDto> booksDto = new ArrayList<>();
		CategoryBookResponseDto categoryBook = new CategoryBookResponseDto();
		
		books.stream().forEach(book -> {
			BookDto bookDto = new BookDto();
			BeanUtils.copyProperties(book, bookDto);
			booksDto.add(bookDto);
		});
		categoryBook.setData(booksDto);
		categoryBook.setStatusCode(HttpStatus.OK.value());
		categoryBook.setMessage(ExceptionConstants.CATEGORY_BOOK);
		return categoryBook;
	}

}
