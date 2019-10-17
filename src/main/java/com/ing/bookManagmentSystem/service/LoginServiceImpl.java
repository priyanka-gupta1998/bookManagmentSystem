package com.ing.bookManagmentSystem.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bookManagmentSystem.dto.RequestLoginDto;
import com.ing.bookManagmentSystem.dto.ResponseLoginDto;
import com.ing.bookManagmentSystem.entity.User;
import com.ing.bookManagmentSystem.exception.CommonException;
import com.ing.bookManagmentSystem.repository.LoginRepository;
import com.ing.bookManagmentSystem.util.ExceptionConstants;




@Service
public class LoginServiceImpl implements LoginService
{ 
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);
     @Autowired
     LoginRepository loginRepository;

  
 
     /**
 	 * @author Priyanka Gupta
 	 * @apiNote emailId and Password we need to pass
 	 * @return message for login 
 	 */
	
	public ResponseLoginDto login(RequestLoginDto requestLoginDto) {
		LOGGER.info("login service");
	User userDetails=loginRepository.findByEmailIdAndPassword(requestLoginDto.getEmailId(),
				requestLoginDto.getPassword());
	if(userDetails!=null)
	{
		Integer userId=userDetails.getUserId();
		String firstName=userDetails.getFirstName();
		String lastName=userDetails.getLastName();
		
			 
		ResponseLoginDto responseLoginDto=new ResponseLoginDto();
			  
		responseLoginDto.setUserId(userId);
			  
		responseLoginDto.setFirstName(firstName);
			  
		responseLoginDto.setLastName(lastName);
			 
		return responseLoginDto;
	}


		  else
		  {
			  throw new CommonException(ExceptionConstants.USER_NOT_FOUND);
		  }
	}	
	
	
	}