package com.ing.bookManagmentSystem.dto;

import java.time.LocalDate;
import java.util.Date;

public class RequestBorrowedBooksDetailsDto {
private String bookName;
private LocalDate borrowedStartDate;
private LocalDate borrowedEndDate;

public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public LocalDate getBorrowedStartDate() {
	return borrowedStartDate;
}
public void setBorrowedStartDate(LocalDate localDate) {
	this.borrowedStartDate = localDate;
}
public LocalDate getBorrowedEndDate() {
	return borrowedEndDate;
}
public void setBorrowedEndDate(LocalDate borrowedEndDate) {
	this.borrowedEndDate = borrowedEndDate;
}

}
