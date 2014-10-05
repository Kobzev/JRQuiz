package com.jrquiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrquiz.service.QuestionService;

@Controller
@RequestMapping("/")
public class HelloController {

	@Autowired
	QuestionService questionService;

	@RequestMapping("/hello")
	public String printAllQuestions(ModelMap model) {

		model.addAttribute("allQuestions", questionService.getAllQuestions());
		return "question/allQuestions";

	}

}
