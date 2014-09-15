package com.jrquiz.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.jrquiz.domain.User;

public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;

	// Registration users

	@Override
	@Transactional
	public int insertUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		user.setCreatedDate(new Timestamp(new Date().getTime()));
		user.setUpdatetime(new Timestamp(new Date().getTime()));
		session.save(user);
		tx.commit();
		Serializable id = session.getIdentifier(user);
		session.close();
		return (Integer) id;
	}

	@Override
	public int confirmUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public User findUserByName(String name) {
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery("select * from Users where username = :name").addEntity(User.class);
		query.setString("name", name);
		@SuppressWarnings("unchecked")
		List<User> userList = query.list();
		session.close();

		if (userList.size() == 0)
			return null;
		return userList.get(0);

	}

	public User findUserByEmail(String email) {
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery("select * from Users where email = :email").addEntity(User.class);
		query.setString("email", email);
		@SuppressWarnings("unchecked")
		List<User> userList = query.list();
		session.close();

		if (userList.size() == 0)
			return null;
		return userList.get(0);

	}

}
