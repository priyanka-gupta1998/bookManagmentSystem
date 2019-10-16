package com.ing.bookManagmentSystem.service;

import org.springframework.stereotype.Service;

import com.ing.bookManagmentSystem.dto.RegisterDto;
import com.ing.bookManagmentSystem.dto.RegisterResponseDto;

@Service
public interface UserService {

	public RegisterResponseDto register(RegisterDto registerDto);
}
