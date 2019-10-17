/**
 * 
 */
package com.ing.bookManagmentSystem.dto;

import java.util.Date;

/**
 * @author srinivas
 *
 */
public class DonateBookRequestDTO {
	private String bookName;
	private String bookAuthor;
	private String bookPublisher;
	private String description;
	private String bookCategory;
	private String bookStatus;
	private Date donatedDate;
	private Integer userId;

	public String getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public Date getDonatedDate() {
		return donatedDate;
	}

	public void setDonatedDate(Date donatedDate) {
		this.donatedDate = donatedDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
