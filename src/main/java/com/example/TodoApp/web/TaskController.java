package com.example.TodoApp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.TodoApp.domain.Task;
import com.example.TodoApp.domain.TaskRepository;
import com.example.TodoApp.domain.User;
import com.example.TodoApp.domain.UserRepository;
import com.example.TodoApp.service.UserServiceImpl;

@Controller
public class TaskController {
	
	@Autowired
	TaskRepository trepo;
	@Autowired
	UserRepository urepo;
	
	@GetMapping(value="/login")
	public String login() {
		return "login";
	}
	
	/**login form
	@PostMapping(value="/login")
	public String userLogin() {
		return "redirect:/todos";
	} */
	//main application 
	@GetMapping(value="/todos")
	public String findTodos(Model model) {
		model.addAttribute("tasks", trepo.findAll());
		return "todos";
	}
	/**edit todo's description and schedule
	@GetMapping(value="/edit/{id}")
	public String editTaskbyId(@PathVariable("id") final String taskId, Model model) {
		model.addAttribute("task", trepo.findById(taskId));
		return "edittask";
	}*/
	//adding todo's 
	@RequestMapping(value="/add")
	public String createTask(Model model) {
		model.addAttribute("task", new Task());
		return "addtask";
	}
	//save method for edit and create
	@PostMapping(value="/save")
	public String save(Task task) {
		if(task.getId().equals(null)) {
			return "addtask";
		}
		else {
		trepo.insert(task);
		return "redirect:todos";
		}
	}
	//delete todo by id
	@GetMapping(value="/del/{description}")
	public String delete(@PathVariable String description, Model model) {
		trepo.deleteByDescription(description);
		model.addAttribute("tasks", trepo.findAll());
		return "todos";
	}
	
	//REST all todo's
	@RequestMapping(value="/tasks")
	public @ResponseBody List<Task> taskList() {
		return (List<Task>) trepo.findAll();
	}
	
	//REST get todo by id
	@RequestMapping(value="/task/{id}")
	public @ResponseBody List<Task> findTask(@PathVariable("id") String taskId) {
		return trepo.findById(taskId);
	}
	
	//REST delete todo by id
	@RequestMapping(value="/delete/{id}")
	public @ResponseBody void deleteById(@PathVariable("id") String taskId) {
		trepo.deleteById(taskId);
	}
	
	//REST show users
	@RequestMapping(value="/users")
	public @ResponseBody List<User> showUsers() {
		return (List<User>) urepo.findAll();
	}
}
