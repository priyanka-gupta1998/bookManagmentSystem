
package com.ing.bookManagmentSystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.bookManagmentSystem.entity.Book;

/**
 * @author srinivas
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	public List<Book> findAllBybookCategory(String category);
	

	public Optional<Book> findBybookId(int bookId);

	Optional<Book> findByBookName(String bookName);

}
