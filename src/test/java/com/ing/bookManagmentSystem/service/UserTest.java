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
import com.ing.bookManagmentSystem.dto.RequestLoginDto;
import com.ing.bookManagmentSystem.dto.ResponseLoginDto;
import com.ing.bookManagmentSystem.entity.User;
import com.ing.bookManagmentSystem.exception.CommonException;
import com.ing.bookManagmentSystem.exception.UserExistException;
import com.ing.bookManagmentSystem.repository.LoginRepository;
import com.ing.bookManagmentSystem.repository.UserRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserTest {

	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserServiceImpl userService;
	
	@InjectMocks
	LoginServiceImpl loginService;
	
	@Mock
	 LoginRepository loginRepository;
	
	RegisterDto registerDto = null;
	User user= null;
	
	RequestLoginDto requestLogin = null;
	
	@Before
	public void setUp()
	{
		registerDto = new RegisterDto();
		registerDto.setEmailId("shara@gmail.com");
		registerDto.setFirstName("sha");
		registerDto.setLastName("ath");
		registerDto.setPassword("test@123");
		registerDto.setPhoneNo("1234567890");
		
		requestLogin = new RequestLoginDto();
		requestLogin.setEmailId("shara@gmail.com");
		requestLogin.setPassword("test@123");
		
		user = new User();
		user.setEmailId("shara@gmail.com");
		user.setFirstName("sha");
		user.setLastName("ath");
		user.setPassword("test@123");
		user.setPhoneNo("1234567890");
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
	
	@Test
	public void loginTest()
	{
		Mockito.when(loginRepository.findByEmailIdAndPassword(requestLogin.getEmailId(), requestLogin.getPassword())).thenReturn(user);
		ResponseLoginDto response = loginService.login(requestLogin);
		Assert.assertEquals(response.getUserId(), user.getUserId());
	}
	
	@Test(expected = CommonException.class)
	public void loginTestException()
	{
		Mockito.when(loginRepository.findByEmailIdAndPassword("shar@gmail.com", "test12")).thenReturn(user);
		ResponseLoginDto response = loginService.login(requestLogin);
	}
	
}
