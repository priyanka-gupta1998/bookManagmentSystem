package com.ing.bookManagmentSystem.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author user1
 *
 */
@Entity
public class BorrowedBooks {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer borrowedId;
	private LocalDate borrowedStartDate;
	private LocalDate borrowedEndDate;

	/**
	 * @return the borrowedStartDate
	 */
	public LocalDate getBorrowedStartDate() {
		return borrowedStartDate;
	}

	/**
	 * @param borrowedStartDate the borrowedStartDate to set
	 */
	public void setBorrowedStartDate(LocalDate borrowedStartDate) {
		this.borrowedStartDate = borrowedStartDate;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private User user;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookId", referencedColumnName = "bookId")
	private Book book;

	public Integer getBorrowedId() {
		return borrowedId;
	}

	public void setBorrowedId(Integer borrowedId) {
		this.borrowedId = borrowedId;
	}

	public User getUser() {
		return user;
	}

	public LocalDate getBorrowedEndDate() {
		return borrowedEndDate;
	}

	public void setBorrowedEndDate(LocalDate borrowedEndDate) {
		this.borrowedEndDate = borrowedEndDate;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
