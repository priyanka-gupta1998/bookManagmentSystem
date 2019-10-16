package com.ing.bookManagmentSystem.dto;

import java.util.Date;

public class RequestBorrowedBooksDetailsDto {
private String bookName;
private Date borrowedStartDate;
private Date borrowedEndDate;

public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
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



}
