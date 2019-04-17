package com.example.TodoApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.TodoApp.domain.User;
import com.example.TodoApp.domain.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService {
	
	@Autowired
	private final UserRepository repository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
	this.repository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws
		UsernameNotFoundException {
			User curruser = repository.findByUsername(username);
			UserDetails user = new org.springframework.security.core.userdetails.User(username,
			curruser.getPasswordHash(),
			AuthorityUtils.createAuthorityList(curruser.getRole()));
			return user;
	} 
	
}

