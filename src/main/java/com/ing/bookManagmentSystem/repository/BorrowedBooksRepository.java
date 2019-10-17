/**
 * 
 */
package com.ing.bookManagmentSystem.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.bookManagmentSystem.entity.BorrowedBooks;

/**
 * @author srinivas
 *
 */
@Repository
public interface BorrowedBooksRepository extends JpaRepository<BorrowedBooks, Integer> {

	Optional<List<BorrowedBooks>> findByBorrowedEndDate(LocalDate now2);

	Optional<BorrowedBooks> findByBookBookId(Integer borrowedId);

}
