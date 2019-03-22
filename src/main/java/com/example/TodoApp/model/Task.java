package com.example.TodoApp.model;

import org.springframework.data.annotation.Id;

public class Task {
	
	@Id
	public long id;
	
	public String title;
	
	public Task() {}
	
	public Task(String title) {
		this.title = title;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	 
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return title;
	}
}
