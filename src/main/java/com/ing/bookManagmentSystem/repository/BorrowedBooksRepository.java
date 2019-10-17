package com.ing.bookManagmentSystem.repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ing.bookManagmentSystem.entity.BorrowedBooks;


@Repository
public interface BorrowedBooksRepository extends JpaRepository<BorrowedBooks, Integer>{

	/*
	 * @Query("SELECT b FROM  BorrowedBooks b where b.user.userId=:userId AND b.book.bookId=:bookId"
	 * ) List<BorrowedBooks> findAllById(Integer userId,Integer bookId);
	 */
	@Query("SELECT b FROM  BorrowedBooks b where b.user.userId=:userId " )
	Optional<List<BorrowedBooks>> findAllById(Integer userId);
	Optional<List<BorrowedBooks>> findByBorrowedEndDate(LocalDate now2);

	Optional<BorrowedBooks> findByBookBookId(Integer borrowedId);

}
