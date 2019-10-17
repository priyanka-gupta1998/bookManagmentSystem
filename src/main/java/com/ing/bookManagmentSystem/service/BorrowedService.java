package com.ing.bookManagmentSystem.service;

import java.util.List;

import com.ing.bookManagmentSystem.dto.BorrowedBookResponseDto;
import com.ing.bookManagmentSystem.dto.ResponseLoginDto;
import com.ing.bookManagmentSystem.entity.BorrowedBooks;

public interface BorrowedService {
public BorrowedBookResponseDto borrowedDetails(Integer userId);

}
