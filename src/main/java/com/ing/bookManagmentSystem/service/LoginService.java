package com.ing.bookManagmentSystem.service;

import com.ing.bookManagmentSystem.dto.RequestLoginDto;
import com.ing.bookManagmentSystem.dto.ResponseLoginDto;

public interface LoginService {
	public ResponseLoginDto login(RequestLoginDto requestLoginDto);

}
