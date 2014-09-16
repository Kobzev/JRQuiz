package com.jrquiz.dao;

import com.jrquiz.domain.User;

public interface DataDao {
	// Registration users
	public int insertUser(User user);

	public int updateUser(User user);

	public User confirmUser(String emailToken);

	public User findUserByName(String name);

	public User findUserByID(int ID);

	public User findUserByEmail(String email);

	public User findUserByEmailToken(String emailToken);
}
