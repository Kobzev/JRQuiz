package com.jrquiz.services;

import com.jrquiz.domain.User;

public interface DataService {
	// Registration users
	public int insertUser(User user);

	public User confirmUser(String emailToken);

	public boolean chekUserName(User user);

	public boolean chekUserEmail(User user);
}
