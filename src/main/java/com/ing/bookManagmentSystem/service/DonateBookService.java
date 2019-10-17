/**
 * 
 */
package com.ing.bookManagmentSystem.service;

import com.ing.bookManagmentSystem.dto.DonateBookRequestDTO;
import com.ing.bookManagmentSystem.entity.Book;

/**
 * @author srinivas
 *
 */
public interface DonateBookService {
	public Book addBook(DonateBookRequestDTO donateBook);

}
