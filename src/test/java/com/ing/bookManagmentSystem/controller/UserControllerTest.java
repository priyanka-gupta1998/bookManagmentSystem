package com.ing.bookManagmentSystem.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ing.bookManagmentSystem.dto.RegisterDto;
import com.ing.bookManagmentSystem.dto.RegisterResponseDto;
import com.ing.bookManagmentSystem.service.UserService;
import com.ing.bookManagmentSystem.util.ExceptionConstants;

/**
 * 
 * @author Sharath G S
 * @apiNote user controller test
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {
	
	@Mock
	UserService userService;
	
	@InjectMocks
	UserController userController;
	
	RegisterDto registerDto = null;
	RegisterResponseDto responseDto = null;
	
	@Before
	public void setUp()
	{
		registerDto = new RegisterDto();
		registerDto.setEmailId("Sharathgs777@gmail.com");
		registerDto.setFirstName("Sharath");
		registerDto.setLastName("G");
		registerDto.setPassword("test@123");
		registerDto.setPhoneNo("1234567890");
		
		responseDto = new RegisterResponseDto();
		responseDto.setMessage(ExceptionConstants.USER_CREATION);
		responseDto.setStatusCode(ExceptionConstants.SUCCESS);
	}

	/**
	 * @author Sharath G S
	 * @apiNote controller test case for registering a user
	 */
	@Test
	public void userControllerTestCase()
	{
		Mockito.when(userService.register(registerDto)).thenReturn(responseDto);
		ResponseEntity<RegisterResponseDto> responseEntity = userController.register(registerDto);
		RegisterResponseDto registerResponse = responseEntity.getBody();
		Assert.assertEquals(registerResponse.getMessage(), responseDto.getMessage());
	}
}
