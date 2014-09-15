package com.jrquiz.services;

import com.jrquiz.domain.User;

public interface DataService {
	// Registration users
	public int insertUser(User user);

	public int confirmUser(User user);
}
