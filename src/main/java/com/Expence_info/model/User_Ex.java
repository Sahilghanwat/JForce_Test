package com.Expence_info.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user_Records")
public class User_Ex {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="email")
	private String email;
	@Column(name="fullname")
	private String fullname;
	
	@OneToMany(mappedBy = "user")
    private List<Expence> expenses;
	
	
	public User_Ex() {
		
	}


	public User_Ex(int id, String username, String password, String email, String fullname) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.fullname = fullname;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	  public List<Expence> getExpenses() {
	        return expenses;
	    }
	    
	    public void setExpenses(List<Expence> expence) {
	        this.expenses = expenses;
	    }
	
	
	
	
	


}
