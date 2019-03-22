package com.example.TodoApp.model;

import org.springframework.data.annotation.Id;

public class User {
	
	@Id
	public String username;
	
	public String password;
	public String email;
	public String role;
	
	public User() {}
	
	public User(String username, String email, String role) {
		this.username = username;
		this.email = email;
		this.role = role;
	}
	
	
	@Override
	public String toString() {
		return username+" "+email+" "+role;
	}
} 
