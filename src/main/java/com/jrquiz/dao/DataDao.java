package com.jrquiz.dao;

import com.jrquiz.domain.User;

public interface DataDao {
	// Registration users
	public int insertUser(User user);

	public int confirmUser(User user);

	public User findUserByName(String name);

	public User findUserByEmail(String email);
}
