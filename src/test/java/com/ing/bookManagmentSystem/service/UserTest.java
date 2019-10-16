package com.ing.bookManagmentSystem.service;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.ing.bookManagmentSystem.dto.RegisterDto;
import com.ing.bookManagmentSystem.dto.RegisterResponseDto;
import com.ing.bookManagmentSystem.entity.User;
import com.ing.bookManagmentSystem.exception.UserExistException;
import com.ing.bookManagmentSystem.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {

	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserServiceImpl userService;
	
	RegisterDto registerDto = null;
	User user= null;
	
	@Before
	public void setUp()
	{
		registerDto = new RegisterDto();
		registerDto.setEmailId("shara@gmail.com");
		registerDto.setFirstName("sha");
		registerDto.setLastName("ath");
		registerDto.setPassword("test@123");
		registerDto.setPhoneNo(1234567890);
		
		user = new User();
		user.setEmailId("shara@gmail.com");
		user.setFirstName("sha");
		user.setLastName("ath");
		user.setPassword("test@123");
		user.setPhoneNo(1234567890);
	}
	
	@Test
	public void registertest()
	{
		Mockito.when(userRepository.save(user)).thenReturn(user);
		RegisterResponseDto response = userService.register(registerDto);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK.value());
	}
	
	
	@Test(expected = UserExistException.class)
	public void registertestforEmailValidation()
	{
		Mockito.when(userRepository.findByemailId(registerDto.getEmailId())).thenReturn(Optional.of(user));
		RegisterResponseDto response = userService.register(registerDto);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.FOUND.value());
	}
	
}
