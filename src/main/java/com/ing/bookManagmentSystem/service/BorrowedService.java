package com.ing.bookManagmentSystem.service;

import com.ing.bookManagmentSystem.dto.BorrowedBookResponseDto;
import com.ing.bookManagmentSystem.dto.RequestResponseDto;

public interface BorrowedService {
public BorrowedBookResponseDto borrowedDetails(Integer userId);
public RequestResponseDto requestEndDate(Integer bookId);

}
