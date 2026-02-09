package com.Expence_info.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Expence_info.model.Expence;
import com.Expence_info.model.User_Ex;
import com.Expence_info.repository.User_Ex_repo;
import com.Expence_info.service.Expence_Service;
import com.Expence_info.service.User_Ex_Service;

@Controller
public class User_Ex_Controller {
	
	@Autowired
	private User_Ex_Service user_ser;
	@Autowired
	private Expence_Service expence_ser;
	@Autowired
	private User_Ex_repo user_repo;

    // showLoginPage
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username,@RequestParam String password,Model model) 
    {

        Optional<User_Ex> user =user_repo.findByUsernameAndPassword(username, password);

        if (user.isPresent()) {
            return "redirect:/allExpances";
        } else {
            model.addAttribute("error", "Invalid Username or Password");
            return "login";
        }
    }

    // showRegistrationPage
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User_Ex());
        return "register";
    }

    // saveUser
    @PostMapping("/register")
    public String registerUser(User_Ex user) {
        user_repo.save(user);
        return "redirect:/login";
    }
	
	
	// showAllExpenses
    @GetMapping("/allExpances")
    public String allExpenses(Model model) {
        List<Expence> expenses = expence_ser.getAllExpenses();
        model.addAttribute("expenses", expenses);
        return "All_Expances";
    }

	//addNewExpenceData
    @GetMapping("/addExpense")
    public String showAddExpenseForm(Model model) {
        Expence expense = new Expence();
        expense.setDate(LocalDate.now());
        model.addAttribute("expense", expense);
        return "Add_Expense";
    }
    
    @PostMapping("/saveExpense")
    public String saveExpense(@ModelAttribute("expense") Expence expense) {
        expence_ser.saveExpense(expense);
        return "redirect:/allExpances";
    }

	//editDataOfExpences
    @GetMapping("/editExpense/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Expence expense = expence_ser.getExpenseById(id)
                                     .orElseThrow(() -> new RuntimeException("Expense not found"));
        model.addAttribute("expense", expense);
        return "Edit_Expense";
    }
    
    @PostMapping("/updateExpense/{id}")
    public String updateExpense(@PathVariable int id, @ModelAttribute("expense") Expence expense) {
        expense.setId(id);
        expence_ser.saveExpense(expense);
        return "redirect:/allExpances";
    }

	//deleteExpencen
    @GetMapping("/deleteExpense/{id}")
    public String deleteExpense(@PathVariable int id) {
        expence_ser.deleteExpense(id);
        return "redirect:/allExpances";
    }
    	
}


 



