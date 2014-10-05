package com.jrquiz.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jrquiz.entity.User;
import com.jrquiz.service.EmailService;

//@Repository
//public interface UserRepository extends JpaRepository<User, Long> {
//}

@Repository
@Transactional(readOnly = true)
public class UserRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Inject
	private PasswordEncoder passwordEncoder;

	@Inject
	private EmailService emailService;

	@Transactional
	public User save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setEmailtoken(passwordEncoder.encode(user.getEmail()));
		entityManager.persist(user);
		emailService.sendRegistrationEmail(user);
		return user;
	}

	@Transactional
	public User confirmUser(String emailToken) {
		User user = entityManager.createNamedQuery(User.FIND_BY_EMAILTOKEN, User.class).setParameter("emailtoken", emailToken).getSingleResult();
		if (user != null) {
			user.setEnabled(true);
			entityManager.persist(user);
		}
		// Session session = sessionFactory.openSession();
		// Query query =
		// session.createSQLQuery("select * from Users where emailtoken = :emailtoken").addEntity(User.class);
		// query.setString("emailtoken", emailToken);
		// @SuppressWarnings("unchecked")
		// List<User> userList = query.list();
		// session.close();
		//
		// if (userList.size() == 0)
		// return null;
		//
		// User user = userList.get(0);
		// user.setEnabled(true);
		// session = sessionFactory.openSession();
		// Transaction tx = session.beginTransaction();
		// session.saveOrUpdate(user);
		// GroupMembers authorities = new GroupMembers();
		// authorities.setUsername(user.getUsername());
		// authorities.setGroupID(1);
		// session.save(authorities);
		// tx.commit();
		// session.close();
		return user;
	}

	public User findByEmail(String email) {
		try {
			return entityManager.createNamedQuery(User.FIND_BY_EMAIL, User.class).setParameter("email", email).getSingleResult();
		} catch (PersistenceException e) {
			return null;
		}
	}

}
