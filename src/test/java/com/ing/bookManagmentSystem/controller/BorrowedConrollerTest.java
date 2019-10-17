package com.ing.bookManagmentSystem.controller;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.bookManagmentSystem.dto.RequestResponseDto;
import com.ing.bookManagmentSystem.service.BorrowedService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BorrowedBooksController.class)
public class BorrowedConrollerTest {

	@Autowired
	MockMvc mockMvc;
	@MockBean
	BorrowedService borrowedService;

	RequestResponseDto responseDto;

	@Before
	public void setup() {
		responseDto = new RequestResponseDto();
		responseDto.setEndDate(LocalDate.now());
		responseDto.setMessage("Book Borrowed Date");
	}

	@Test
	public void borrowedEndTest() throws Exception {
		Mockito.when(borrowedService.requestEndDate(Mockito.anyInt())).thenReturn(responseDto);
		mockMvc.perform(MockMvcRequestBuilders.get("/books/availability/1").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(responseDto))).andExpect(MockMvcResultMatchers.status().isOk());
	}

	public static String asJsonString(final Object obj) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(obj);
	}

}
