package com.jrquiz.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.jrquiz.entity.User;

public interface UserService extends UserDetailsService {
	// User addUser(User user);
	//
	// User getUser(Long id);

	void signin(User user);
}
