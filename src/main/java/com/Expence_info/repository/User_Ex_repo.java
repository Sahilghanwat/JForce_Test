package com.Expence_info.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Expence_info.model.User_Ex;


@Repository
public interface User_Ex_repo extends JpaRepository<User_Ex,Integer> {
	
	Optional<User_Ex> findByUsernameAndPassword(String username, String password);

	

}
