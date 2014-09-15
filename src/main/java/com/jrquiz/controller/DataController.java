package com.jrquiz.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jrquiz.domain.User;
import com.jrquiz.services.DataService;
import com.jrquiz.services.EmailService;

@Controller
public class DataController {

	@Autowired
	DataService dataService;

	@Autowired
	EmailService emailService;

	@RequestMapping("home")
	public ModelAndView goToHomePage() {
		return new ModelAndView("home");
	}

	// Register user
	@RequestMapping("registerPage")
	public ModelAndView goToRegisterPage(@ModelAttribute User user) {
		return new ModelAndView("registerPage");
	}

	@RequestMapping("confirm")
	public ModelAndView confirm(@RequestParam String id) {
		User user = dataService.confirmUser(id);
		ModelAndView modelAndView = new ModelAndView("redirect:confirmRegistration");
		modelAndView.addObject(user);
		return modelAndView;
	}

	@RequestMapping("confirmRegistration")
	public ModelAndView confirmRegistration(@ModelAttribute User user) {
		return new ModelAndView("confirmRegistration");
	}

	@RequestMapping("registerUser")
	public ModelAndView registerNewUser(@Valid @ModelAttribute User user, BindingResult bindingResult) {
		if (!dataService.chekUserEmail(user)) {
			bindingResult.addError(new FieldError("user", "email", "Пользователь с таким e-mail уже существует"));
		}
		if (!dataService.chekUserName(user)) {
			bindingResult.addError(new FieldError("user", "username", "Пользователь с таким именем уже существует"));
		}
		if (bindingResult.hasErrors()) {
			return new ModelAndView("registerPage");
		}

		if (dataService.insertUser(user) < 0 && !emailService.sendEmail(user)) {
			return new ModelAndView("registerPage");
		}
		return new ModelAndView("redirect:login");
	}

	// Security

	@Autowired
	private AccessDecisionManager accessDecisionManager;

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		// пока русский текст без локализации, хотя так не рекомендуется!
		if (user != null) {
			model.addObject("errorMsg", user.getName() + " у вас нет доступа к этой странице!");
		} else {
			model.addObject("errorMsg", "У вас нет доступа к этой странице!");
		}

		model.setViewName("/accessDenied");
		return model;

	}

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error, Model model) {

		ModelAndView modelView = new ModelAndView();
		if (error != null) {
			modelView.addObject("error", "Invalid username or password!");
		}

		modelView.setViewName("login");

		return modelView;

	}
}
