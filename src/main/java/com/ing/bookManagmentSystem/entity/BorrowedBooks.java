package com.ing.bookManagmentSystem.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class BorrowedBooks {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Integer borrowedId;
	private Date borrowedStartDate;
	private Date borrowedEndDate;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId",referencedColumnName = "userId")
	private User user; 
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookId",referencedColumnName = "bookId")
	private Book book;
	public Integer getBorrowedId() {
		return borrowedId;
	}
	public void setBorrowedId(Integer borrowedId) {
		this.borrowedId = borrowedId;
	}
	public Date getBorrowedStartDate() {
		return borrowedStartDate;
	}
	public void setBorrowedStartDate(Date borrowedStartDate) {
		this.borrowedStartDate = borrowedStartDate;
	}
	public Date getBorrowedEndDate() {
		return borrowedEndDate;
	}
	public void setBorrowedEndDate(Date borrowedEndDate) {
		this.borrowedEndDate = borrowedEndDate;
	}
	public User getUser() {
		return user;
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
