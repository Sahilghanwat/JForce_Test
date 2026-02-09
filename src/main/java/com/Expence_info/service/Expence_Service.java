package com.Expence_info.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Expence_info.model.Expence;
import com.Expence_info.repository.Expence_Repository;

@Service
public class Expence_Service {
	
	    @Autowired
	    private Expence_Repository expense_repo;
	    
	    // Getallexpenses
	    public List<Expence> getAllExpenses() {
	        return expense_repo.findAll();
	    }
	    
	    // Get expense by ID
	    public Optional<Expence> getExpenseById(int id) {
	        return expense_repo.findById(id);
	    }
	    

	    
	    // Save expense
	    public Expence saveExpense(Expence expense) {
	        return expense_repo.save(expense);
	    }
	    
	    // Delete expense
	    public void deleteExpense(int id) {
	        expense_repo.deleteById(id);
	    }
	    

	}


