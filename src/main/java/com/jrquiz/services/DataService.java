package com.jrquiz.services;

import com.jrquiz.domain.User;

public interface DataService {
	// Registration users
	public int insertUser(User user);

	public int updateUser(User user, User updateUser);

	public int updatePasswordUser(User user);

	public User confirmUser(String emailToken);

	public boolean chekUserName(User user);

	public boolean chekUserEmail(User user);

	public User findUserByEmail(String email);

	public User findUserByID(int ID);

	public User findUserByName(String name);

	public User findUserByEmailToken(String emailToken);
}
