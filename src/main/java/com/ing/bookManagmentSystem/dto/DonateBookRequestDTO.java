package com.ing.bookManagmentSystem.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author srinivas
 * Used to pass donate book request
 */
public class DonateBookRequestDTO {
	@NotBlank(message = "bookName is mandatory")
	@NotNull(message = "bookName cannot be null")
	@Size(min = 2)
	private String bookName;
	private String bookAuthor;
	private String bookPublisher;
	private String description;
	private String bookCategory;
	@NotBlank(message = "bookStatus is mandatory")
	@NotNull(message = "bookStatus cannot be null")
	private String bookStatus;
	private Date donatedDate;

	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * @return the bookAuthor
	 */
	public String getBookAuthor() {
		return bookAuthor;
	}

	/**
	 * @param bookAuthor the bookAuthor to set
	 */
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	/**
	 * @return the bookPublisher
	 */
	public String getBookPublisher() {
		return bookPublisher;
	}

	/**
	 * @param bookPublisher the bookPublisher to set
	 */
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the bookCategory
	 */
	public String getBookCategory() {
		return bookCategory;
	}

	/**
	 * @param bookCategory the bookCategory to set
	 */
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	/**
	 * @return the bookStatus
	 */
	public String getBookStatus() {
		return bookStatus;
	}

	/**
	 * @param bookStatus the bookStatus to set
	 */
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	/**
	 * @return the donatedDate
	 */
	public Date getDonatedDate() {
		return donatedDate;
	}

	/**
	 * @param donatedDate the donatedDate to set
	 */
	public void setDonatedDate(Date donatedDate) {
		this.donatedDate = donatedDate;
	}
}
