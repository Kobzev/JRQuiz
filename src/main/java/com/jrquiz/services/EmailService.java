package com.jrquiz.services;

import com.jrquiz.domain.User;

public interface EmailService {
	public boolean sendRegistrationEmail(User user);

	public boolean sendRemaindPasswordMail(User user);
}
