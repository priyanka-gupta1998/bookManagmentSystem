package com.ing.bookManagmentSystem.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ing.bookManagmentSystem.dto.RegisterDto;
import com.ing.bookManagmentSystem.dto.RegisterResponseDto;
import com.ing.bookManagmentSystem.entity.User;
import com.ing.bookManagmentSystem.exception.UserExistException;
import com.ing.bookManagmentSystem.repository.UserRepository;
import com.ing.bookManagmentSystem.util.ExceptionConstants;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	UserRepository userRepository;
	
	/**
	 *@author Sharath
	 *@apiNote service for saving user details
	 *@return user registered successfully
	 *
	 */
	@Override
	public RegisterResponseDto register(RegisterDto registerDto) {
		
		LOGGER.info("event for user registration service called");
		
		User user = new User();
		RegisterResponseDto response = new RegisterResponseDto();
		
		Optional<User> userData= userRepository.findByemailId(registerDto.getEmailId());
		
		userData.ifPresent(data ->
		{
			LOGGER.info("user service called and user exists");
			throw new UserExistException(ExceptionConstants.USER_EXISTS, HttpStatus.FOUND.value());
		});
			
		LOGGER.info("user service for registartion successfully");
			BeanUtils.copyProperties(registerDto, user);
			userRepository.save(user);
			
			response.setMessage(ExceptionConstants.USER_CREATION);
			response.setStatusCode(HttpStatus.OK.value());
			return response;
		
	}

}
