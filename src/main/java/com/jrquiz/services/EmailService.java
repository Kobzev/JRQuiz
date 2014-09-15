package com.jrquiz.services;

import com.jrquiz.domain.User;

public interface EmailService {
	public boolean sendEmail(User user);
}
