package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
@Configurable
public class UserDAO {
	@Autowired UserRepo usrrepo;

public User updatebyname( User s) {
		
		return usrrepo.save(s); 
		
}
} 