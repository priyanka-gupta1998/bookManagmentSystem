package com.ing.bookManagmentSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.bookManagmentSystem.dto.RegisterDto;
import com.ing.bookManagmentSystem.dto.RegisterResponseDto;
import com.ing.bookManagmentSystem.service.UserService;

@RestController
public class UserController {

	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<RegisterResponseDto> register(RegisterDto registerDto)
	{
		return new ResponseEntity(userService.register(registerDto),HttpStatus.OK);
	}
	
}
