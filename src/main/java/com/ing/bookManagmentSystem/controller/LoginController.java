package com.ing.bookManagmentSystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ing.bookManagmentSystem.dto.RequestLoginDto;
import com.ing.bookManagmentSystem.dto.ResponseLoginDto;
import com.ing.bookManagmentSystem.exception.CommonException;
import com.ing.bookManagmentSystem.service.LoginService;
import com.ing.bookManagmentSystem.util.ExceptionConstants;




@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/login")
public class LoginController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	LoginService loginService;
	/**
	 * @author Sharath G S
	 * @apiNote list of books by search
	 * @return list of books
	 */
	@PostMapping("")
	public ResponseLoginDto borrowedDetails(@RequestBody RequestLoginDto requestLoginDto)
	{
<<<<<<< HEAD
		LOGGER.info("event for user controller  called");
=======
		LOGGER.info("Login controller");
>>>>>>> feature1
		ResponseLoginDto requestBorrowedBooksDetails=loginService.login(requestLoginDto);
	   if(requestBorrowedBooksDetails!=null)
	   {
		   requestBorrowedBooksDetails.setStatusCode(201);
			requestBorrowedBooksDetails.setMessage("Login Successfull !!");
			return requestBorrowedBooksDetails;
	   }
		
	   else
	   {
		   throw new CommonException(ExceptionConstants.INVALID_CREDENTIALS);
	   }
		
	}

	
}
