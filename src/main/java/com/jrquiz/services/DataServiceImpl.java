package com.jrquiz.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.jrquiz.dao.DataDao;
import com.jrquiz.domain.User;

public class DataServiceImpl implements DataService {

	@Autowired
	DataDao dataDao;

	// All actions with users

	@Override
	public int insertUser(User user) {
		return dataDao.insertUser(user);
	}

	@Override
	public int updateUser(User user, User newUser) {
		user.setPassword(newUser.getPassword());
		return dataDao.updateUser(user);
	}

	@Override
	public int updatePasswordUser(User user) {
		return dataDao.updateUser(user);
	}

	@Override
	public User confirmUser(String emailToken) {
		User user = dataDao.confirmUser(emailToken);
		return user;
	}

	@Override
	public boolean chekUserName(User user) {
		User checkedUser = dataDao.findUserByName(user.getUsername());
		if (checkedUser == null)
			return true;
		return false;
	}

	@Override
	public boolean chekUserEmail(User user) {
		User checkedUser = dataDao.findUserByEmail(user.getEmail());
		if (checkedUser == null)
			return true;
		return false;
	}

	@Override
	public User findUserByEmail(String email) {
		return dataDao.findUserByEmail(email);
	}

	@Override
	public User findUserByName(String name) {
		return dataDao.findUserByName(name);
	}

	@Override
	public User findUserByEmailToken(String emailToken) {
		return dataDao.findUserByEmailToken(emailToken);
	}

	@Override
	public User findUserByID(int ID) {
		return dataDao.findUserByID(ID);
	}

}
