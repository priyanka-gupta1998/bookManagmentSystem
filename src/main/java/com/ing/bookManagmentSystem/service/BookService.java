package com.ing.bookManagmentSystem.service;

import org.springframework.stereotype.Service;

import com.ing.bookManagmentSystem.dto.CategoryBookResponseDto;

@Service
public interface BookService {

	public CategoryBookResponseDto getBooks(String category);
}