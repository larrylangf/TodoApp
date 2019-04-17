package com.example.TodoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.TodoApp.domain.Task;
import com.example.TodoApp.domain.TaskRepository;
import com.example.TodoApp.domain.User;
import com.example.TodoApp.domain.UserRepository;

@SpringBootApplication
public class TodoAppApplication {

	@Autowired
	private TaskRepository trepo;
	@Autowired
	private UserRepository urepo;
	
	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner appData() { 
		return (args) -> {
		
		trepo.deleteAll();
		
		trepo.insert(new Task("daily scrum"));
		trepo.insert(new Task("buy supplements to office"));
		trepo.insert(new Task("attend to conference"));
		
		urepo.deleteAll();
		
		urepo.insert(new User("admin", "$2a$10$AI4D/RpJwTaSLxgQZgrT4OuELP5ZbYafRVLQpAjU55eMfjIMyuvbO", "ADMIN"));
		urepo.insert(new User("user", "$2a$10$PwJULTBRPPzVfvUG4KJhjOde3VC6Q5xREekqIUJMJOTER343u9xte", "USER"));
	};
  }
}

