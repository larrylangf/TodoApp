package com.example.TodoApp.domain;

import org.springframework.data.annotation.Id;

public class Task {
	
	@Id
	public String id;
	
	public String title;
	
	public Task() {}
	
	public Task(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
