package com.Expence_info.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Expence_info.model.User_Ex;
import com.Expence_info.repository.User_Ex_repo;

@Service
public class User_Ex_Service {
	
	@Autowired
	private User_Ex_repo user_repo;
	
	
	//get all information
	
	public List<User_Ex> allUserExpance()
	{
		return user_repo.findAll();
	}
	
	
	//getUserById
	
	public Optional<User_Ex> getUserExById(int id)
	{
		return Optional.ofNullable(user_repo.findById(id).orElseThrow());
		
	}
	
	
	
	//saveUSerExpance
	
	public User_Ex saveUserEx(User_Ex user_ex)
	{
		return user_repo.save(user_ex);
	}
	
	
	
	//deleteUserExpance
	
	public void deleteuserExpanceById(int id)
	{
		user_repo.deleteById(id);
	}
	
	

}
