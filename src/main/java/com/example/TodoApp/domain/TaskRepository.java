package com.example.TodoApp.domain;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<Task, Long> {
	

	public List<Task> findById(String id);
	
	public List<Task> deleteById(String id);
	
	public List<Task> deleteByDescription(String description);
}

