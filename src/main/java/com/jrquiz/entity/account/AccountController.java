package com.jrquiz.entity.account;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.jrquiz.entity.User;
import com.jrquiz.repository.UserRepository;

@Controller
@Secured("ROLE_USER")
class AccountController {

	private UserRepository accountRepository;

	@Autowired
	public AccountController(UserRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@RequestMapping(value = "account/current", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public User accounts(Principal principal) {
		Assert.notNull(principal);
		return accountRepository.findByEmail(principal.getName());
	}
}
