package com.jrquiz.service.impl;

import java.util.Collections;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jrquiz.entity.User;
import com.jrquiz.repository.UserRepository;
import com.jrquiz.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	protected void initialize() {
		User user = userRepository.findByEmail("user");
		if (user == null) {
			userRepository.save(new User("user", "user", "ROLE_USER", true));
		}
		user = userRepository.findByEmail("admin");
		if (user == null) {
			userRepository.save(new User("admin", "admin", "ROLE_ADMIN", true));
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("user not found");
		}
		return createUser(user);
	}

	@Override
	public void signin(User user) {
		SecurityContextHolder.getContext().setAuthentication(authenticate(user));
	}

	private Authentication authenticate(User user) {
		return new UsernamePasswordAuthenticationToken(createUser(user), null, Collections.singleton(createAuthority(user)));
	}

	private org.springframework.security.core.userdetails.User createUser(User user) {
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), Collections.singleton(createAuthority(user)));
	}

	private GrantedAuthority createAuthority(User user) {
		return new SimpleGrantedAuthority(user.getRole());
	}

	// @Autowired
	// private UserRepository userRepository;
	//
	// @Override
	// public User addUser(User user) {
	// return userRepository.saveAndFlush(user);
	// }
	//
	// @Override
	// public User getUser(Long id) {
	// return userRepository.findOne(id);
	// }
}
