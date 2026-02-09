package com.Expence_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Expence_info.model.Expence;

@Repository
public interface Expence_Repository extends JpaRepository<Expence,Integer>{
	
	

}
