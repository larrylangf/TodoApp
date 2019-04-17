package com.example.TodoApp.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.TodoApp.domain.UserForm;
import com.example.TodoApp.domain.User;
import com.example.TodoApp.domain.UserRepository;

@Controller
public class UserController {
		
	@Autowired
	private UserRepository urepo;
	
	@RequestMapping(value="/signup")
	public String addUser(Model model) {
		model.addAttribute("userform", new UserForm());
		return "signup";
	}
	
	@PostMapping(value="/saveuser")
	public String saveUser(@Valid @ModelAttribute("userform") UserForm userForm, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) { // validation errors
    		if (userForm.getPassword().equals(userForm.getPasschk()) & userForm.getPassword() != null) { // check password match and not null		
	    		String pwd = userForm.getPassword();
		    	BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		    	String hashPwd = bc.encode(pwd);
	
		    	User user = new User();
		    	user.setPasswordHash(hashPwd);
		    	user.setUsername(userForm.getUsername());
		    	user.setRole("USER");
		    	if (urepo.findByUsername(userForm.getUsername()) == null & userForm.getUsername() != null) { // Check if user exists and given username not null
		    		urepo.save(user);
		    	}
		    	else {
	    			bindingResult.rejectValue("username", "err.username", "Username already exists");    	
	    			return "signup";		    		
		    	}
    		}
    		else {
    			bindingResult.rejectValue("passchk", "err.passchk", "Passwords does not match");    	
    			return "signup";
    		}
    	}
    	else {
    		return "signup";
    	}
		return "redirect:/login";
	}
}

