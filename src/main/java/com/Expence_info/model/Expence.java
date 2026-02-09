package com.Expence_info.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "expense_Records")
public class Expence {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    @Column(name = "title")
    private String title;   
    @Column(name = "amount")
    private Double amount;     
    @Column(name = "date")
    private LocalDate date; 
    @Column(name = "description")
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User_Ex user;
    
    // Constructors
    public Expence() {
    }
    
    public Expence(int id, String title, Double amount,
                   LocalDate date, String description, User_Ex user) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.user = user;
    }
    

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public Double getAmount() {
        return amount;
    }
    
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    

    
    public LocalDate getDate() {
        return date;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public User_Ex getUser() {
        return user;
    }
    
    public void setUser(User_Ex user) {
        this.user = user;
    }
}