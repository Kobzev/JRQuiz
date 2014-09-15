package com.jrquiz.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.jrquiz.dao.DataDao;
import com.jrquiz.domain.User;

public class DataServiceImpl implements DataService {

	@Autowired
	DataDao dataDao;

	// Registration users
	@Override
	public int insertUser(User user) {
		return dataDao.insertUser(user);
	}

	@Override
	public int confirmUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
