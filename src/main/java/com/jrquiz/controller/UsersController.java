package com.jrquiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jrquiz.entity.User;
import com.jrquiz.repository.UserRepository;

@Controller
public class UsersController {
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "confirm")
	public String confirm(@RequestParam(value = "id", required = true) String id) {
		User user = userRepository.confirmUser(id);
		if (user == null) {
			return "signup/wrongRegistration";
		}
		// model.addAttribute("user", user);
		return "signup/confirmRegistration";
	}

}
