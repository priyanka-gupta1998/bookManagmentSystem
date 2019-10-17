package com.ing.bookManagmentSystem.service;


import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ing.bookManagmentSystem.dto.RequestBorrowedBooksDetailsDto;
import com.ing.bookManagmentSystem.dto.RequestLoginDto;
import com.ing.bookManagmentSystem.dto.ResponseLoginDto;
import com.ing.bookManagmentSystem.entity.BorrowedBooks;
import com.ing.bookManagmentSystem.entity.User;
import com.ing.bookManagmentSystem.exception.CommonException;
import com.ing.bookManagmentSystem.repository.BorrowedBooksRepository;
import com.ing.bookManagmentSystem.repository.LoginRepository;
import com.ing.bookManagmentSystem.util.ExceptionConstants;



@Service
public class LoginServiceImpl implements LoginService
{
     @Autowired
     LoginRepository loginRepository;
     @Autowired
     BorrowedBooksRepository borrowedBooksRepository;
     
     /**
 	 *@author Priyanka
 	 *@apiNote service for getting borrwedbooksdetail
 	 *@return user registered successfully
 	 *
 	 */
	
	public ResponseLoginDto login(RequestLoginDto requestLoginDto) {
		List<RequestBorrowedBooksDetailsDto> requestBorrowedBooksDetails=new ArrayList<>();
	User userDetails=loginRepository.findByEmailIdAndPassword(requestLoginDto.getEmailId(),
				requestLoginDto.getPassword());
	if(userDetails!=null)
	{
		Integer userId=userDetails.getUserId();
		String firstName=userDetails.getFirstName();
		String lastName=userDetails.getLastName();
		Optional<List<BorrowedBooks>> borrowedBookDetail=borrowedBooksRepository.findAllById(userId);
		List<BorrowedBooks> borrowedBooks = borrowedBookDetail.get();
		  if(borrowedBooks!=null){
			  borrowedBooks.forEach(borrowedBookDetails->{
				  
				  RequestBorrowedBooksDetailsDto requestBorrowedBooksDetailsDto=new RequestBorrowedBooksDetailsDto();
				  requestBorrowedBooksDetailsDto.setBookName(borrowedBookDetails.getBook().getBookName());
				  requestBorrowedBooksDetails.add(requestBorrowedBooksDetailsDto);
			  });
			  ResponseLoginDto responseLoginDto=new ResponseLoginDto();
			  responseLoginDto.setUserId(userId);
			  responseLoginDto.setFirstName(firstName);
			  responseLoginDto.setLastName(lastName);
			  responseLoginDto.setBorrowedBookDetails(requestBorrowedBooksDetails);
		return responseLoginDto;
	}

		  else
		  {
			  throw new CommonException(ExceptionConstants.USER_NOT_FOUND);
		  }
	}	
	
	else
	{
		throw new CommonException(ExceptionConstants.INVALID_CREDENTIALS);
		
	}
	}
}
