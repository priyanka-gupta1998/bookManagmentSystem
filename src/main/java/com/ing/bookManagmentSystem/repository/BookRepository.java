/**
 * 
 */
package com.ing.bookManagmentSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.bookManagmentSystem.entity.Book;

/**
 * @author srinivas
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	Optional<Book> findByBookName(String bookName);

}
