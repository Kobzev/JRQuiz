package com.jrquiz.config;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.jrquiz.service.UserService;
import com.jrquiz.service.impl.UserServiceImpl;

@Configuration
@ImportResource(value = "classpath:spring-security-context.xml")
class SecurityConfig {

	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}

	@Bean
	public TokenBasedRememberMeServices rememberMeServices() {
		return new TokenBasedRememberMeServices("remember-me-key", userService());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Profile("test")
	@Bean(name = "csrfMatcher")
	public RequestMatcher testCsrfMatcher() {
		return new RequestMatcher() {

			@Override
			public boolean matches(HttpServletRequest request) {
				return false;
			}
		};
	}

	@Profile("!test")
	@Bean(name = "csrfMatcher")
	public RequestMatcher csrfMatcher() {
		/**
		 * Copy of default request matcher from
		 * CsrfFilter$DefaultRequiresCsrfMatcher
		 */
		return new RequestMatcher() {
			private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.springframework.security.web.util.matcher.RequestMatcher#
			 * matches(javax.servlet.http.HttpServletRequest)
			 */
			public boolean matches(HttpServletRequest request) {
				return !allowedMethods.matcher(request.getMethod()).matches();
			}
		};
	}
}