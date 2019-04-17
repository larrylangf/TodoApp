package com.example.TodoApp.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

public class User {
	
	@Id
	private String id;
	@NotNull
	@Size(min=3, max=20)
	private String username;
	@NotNull
	public String passwordhash;
	public String role;
	
	public User() {}
	
	public User(String username, String passwordhash, String role) {
		super();
		this.username = username;
		this.passwordhash = passwordhash;
		this.role = role;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPasswordHash() {
		return passwordhash;
	}
	
	public void setPasswordHash(String passwordhash) {
		this.passwordhash = passwordhash;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return username+" "+" "+role;
	}
} 
