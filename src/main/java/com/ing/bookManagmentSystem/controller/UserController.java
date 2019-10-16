package com.ing.bookManagmentSystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ing.bookManagmentSystem.dto.RegisterDto;
import com.ing.bookManagmentSystem.dto.RegisterResponseDto;
import com.ing.bookManagmentSystem.service.UserService;
import com.ing.bookManagmentSystem.service.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	
	/**
	 * 
	 * @param registerDto
	 * @apiNote register for the user
	 * @author Sharath
	 * @return register successfull or exists 
	 */
	@PostMapping("/register")
	public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterDto registerDto)
	{
		LOGGER.info("event for register controller called");
		return new ResponseEntity(userService.register(registerDto),HttpStatus.OK);
	}
	
}
