package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, String>{

	@Query("select user from User user where user.user=?1")
	public Optional<User> findByUser(String user);
	
	@Query("select user from User user where user.password=?1")
	public Optional<User> findByPassword(String password);
	

}