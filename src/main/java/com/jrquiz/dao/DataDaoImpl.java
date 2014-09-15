package com.jrquiz.dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.jrquiz.domain.Authorities;
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

		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.reset();
			m.update(user.getEmail().getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1, digest);
			String hashtext = bigInt.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			user.setEmailtoken(hashtext);
		} catch (NoSuchAlgorithmException e) {
		}

		session.save(user);
		tx.commit();
		Serializable id = session.getIdentifier(user);
		session.close();
		return (Integer) id;
	}

	@Override
	@Transactional
	public User confirmUser(String emailToken) {
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery("select * from Users where emailtoken = :emailtoken").addEntity(User.class);
		query.setString("emailtoken", emailToken);
		@SuppressWarnings("unchecked")
		List<User> userList = query.list();
		session.close();

		if (userList.size() == 0)
			return null;

		User user = userList.get(0);
		user.setEnabled(true);
		session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(user);
		Authorities authorities = new Authorities();
		authorities.setUsername(user.getUsername());
		authorities.setUserID(user.getId());
		authorities.setAuthority("ROLE_USER");
		session.save(authorities);
		tx.commit();
		session.close();
		return user;
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
