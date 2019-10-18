package com.ing.bookManagmentSystem.service;

import org.springframework.stereotype.Service;

import com.ing.bookManagmentSystem.dto.RegisterDto;
import com.ing.bookManagmentSystem.dto.RegisterResponseDto;

/**
 * @author User1
 *
 */
@Service
public interface UserService {

	/**
	 * @param registerDto
	 * @return
	 */
	public RegisterResponseDto register(RegisterDto registerDto);
}
