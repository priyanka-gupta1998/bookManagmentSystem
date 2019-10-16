package com.ing.bookManagmentSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.bookManagmentSystem.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	
	public Optional<User> findByemailId(String emailId);
}
