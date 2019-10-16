package com.ing.bookManagmentSystem.service;

import java.util.List;

import com.ing.bookManagmentSystem.dto.RequestBorrowedBooksDetailsDto;
import com.ing.bookManagmentSystem.dto.RequestLoginDto;
import com.ing.bookManagmentSystem.dto.ResponseLoginDto;

public interface LoginService {
public ResponseLoginDto login(RequestLoginDto requestLoginDto);

}
