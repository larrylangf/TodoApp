package com.example.TodoApp.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class UserForm {
	
	@NotNull
	@Size(min=3, max=20)
	private String username;
	@NotNull
	private String password;
	@NotNull
	private String passchk;
	private String role = "USER";
	
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
	public String getPasschk() {
		return passchk;
	}
	public void setPasschk(String passchk) {
		this.passchk = passchk;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
