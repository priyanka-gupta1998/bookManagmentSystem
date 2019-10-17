package com.ing.bookManagmentSystem.service;

import com.ing.bookManagmentSystem.dto.BorrowedBookResponseDto;

public interface BorrowedService {
public BorrowedBookResponseDto borrowedDetails(Integer userId);

}
