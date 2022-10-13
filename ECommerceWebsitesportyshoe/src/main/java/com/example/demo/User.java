package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity

public class User {
	

	@Id
	    private String user;
		private String password;
		
}
