package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductDAO {

	@Autowired
	 ProductRepo repo;
public  Product insert( Product s) {
	return	repo.save(s);
	}
	
	
	public List< Product> getAll(){
		return repo.findAll();
	}
	
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	
			
	public  Product updatebyname( Product s) {
		
		Product ss=repo.findById(s.getId()).orElse(null);
		ss.setName(s.getName());
	return repo.save(ss);
		
	}

	}


	
	
	
