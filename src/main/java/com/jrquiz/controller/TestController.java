package com.jrquiz.controller;

import com.jrquiz.entity.Answer;
import com.jrquiz.entity.Question;
import com.jrquiz.entity.Tag;
import com.jrquiz.entity.Test;
import com.jrquiz.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/runtest")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(method = RequestMethod.GET)
    public String ediTag(@RequestParam(value = "t", defaultValue = "1") Long t,
                         @RequestParam(value = "q", defaultValue = "1") Long q, Model model) {

        Test test = testService.getTest(t);

        List<Question> questions = new ArrayList<>(test.getQuestions());

        model.addAttribute("questionsInTest", questions);

        Question currentQuestion = questions.get(q.intValue() - 1);
        model.addAttribute("currentQuestion", currentQuestion);

        List<Answer> answers = new ArrayList<Answer>(currentQuestion.getAnswers());
        model.addAttribute("answers", answers);

        return "test/test";
    }
}
