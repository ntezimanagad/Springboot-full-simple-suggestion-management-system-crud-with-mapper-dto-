package com.ralationship.ralationship.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Suggestion> suggestion;
    public Employee() {
    }
    public Employee(String name, String email, String password, List<Suggestion> suggestion) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.suggestion = suggestion;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<Suggestion> getSuggestion() {
        return suggestion;
    }
    public void setSuggestion(List<Suggestion> suggestion) {
        this.suggestion = suggestion;
    }
    
}
