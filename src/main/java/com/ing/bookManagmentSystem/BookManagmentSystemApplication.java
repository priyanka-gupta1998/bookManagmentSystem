package com.ing.bookManagmentSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BookManagmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManagmentSystemApplication.class, args);
	}

}
