/**
 * 
 */
package com.ing.bookManagmentSystem.service;

import com.ing.bookManagmentSystem.dto.DonateBookRequestDTO;
import com.ing.bookManagmentSystem.dto.DonateBookResponseDTO;

/**
 * @author srinivas
 *
 */
public interface DonateBookService {
	public DonateBookResponseDTO addBook(DonateBookRequestDTO donateBook);

}
