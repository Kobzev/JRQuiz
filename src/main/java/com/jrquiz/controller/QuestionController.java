package com.jrquiz.controller;

import com.jrquiz.controller.choices.QuestionId;
import com.jrquiz.entity.Answer;
import com.jrquiz.entity.Question;
import com.jrquiz.entity.enums.QuestionType;
import com.jrquiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    QuestionService questionService;

    private static Question question;

    @Transactional
    @RequestMapping(value="/showquestion", method=RequestMethod.POST)
    public String show(@ModelAttribute(value="questionid") QuestionId questionId, Model model){ //выводим запрашиваемый тестовый вопрос

        question = questionService.getQuestion(Long.parseLong(questionId.getCheckedId()));
        System.out.println(question.getAnswers().size());
        List<Answer> answers = new ArrayList<Answer>(questionService.getAnswers(question.getId()));

        model.addAttribute("question", question);
        model.addAttribute("answers", answers);

        //В зависимости от типа вопроса выбираем вьюшки.
        if (question.getQuestionType().equals(QuestionType.MULTIANSWER))
            return "question/showCBQuestion";
        else if (question.getQuestionType().equals(QuestionType.SINGLEANSWER))
            return "question/showRBQuestion";
        else if (question.getQuestionType().equals(QuestionType.TYPEANSWER))
            return "question/showTQuestion";
        else
            return "/error/general";


    }

    @RequestMapping("/question")
    public String getQuestionId(Model model){                        //запрашиваем id вопроса

        model.addAttribute("allQuestions", questionService.getAllQuestions());

        QuestionId aid = new QuestionId();
        model.addAttribute("questionid", aid);

        return "/question/requestquestion";
    }
}
