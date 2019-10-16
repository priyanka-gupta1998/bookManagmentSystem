package com.ing.bookManagmentSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.bookManagmentSystem.entity.User;


@Repository
public interface LoginRepository  extends JpaRepository<User, Integer>{

	User findByEmailIdAndPassword(String emailId, String password);
 
}
