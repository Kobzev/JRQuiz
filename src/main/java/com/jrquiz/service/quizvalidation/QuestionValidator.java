package com.jrquiz.service.quizvalidation;

import com.jrquiz.entity.Answer;
import com.jrquiz.entity.Question;
import com.jrquiz.entity.enums.QuestionType;
import com.jrquiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class QuestionValidator {

    @Autowired
    private static QuestionService questionService;

    public static QuestionValidationResult validateQuestion(Question question, Answer... userAnswers) throws Exception {
        QuestionValidationResult result = new QuestionValidationResult(question);
        List<Answer> availableAnswers = new ArrayList<Answer>(questionService.getAnswers(question.getId()));
        List<Answer> correctAnswers = new ArrayList<>();
        for (Answer answer : availableAnswers)
        {
            if (answer.getIsCorrect()) correctAnswers.add(answer);
        }

        if (question.getQuestionType() == QuestionType.TYPEANSWER)
        {
            if (correctAnswers.size() != 1) {
                throw new Exception(String.format("The question %d has multiple correct answers while question type is %s!", question.getId(), question.getQuestionType().toString()));
            }
            if (userAnswers.length != 1) {
                throw new Exception(String.format("User answered with multiple answers while question type is %s!", question.getQuestionType().toString()));
            }

            Answer correctAnswer = correctAnswers.get(0);
            Answer userAnswer = userAnswers[0];

            if (correctAnswer.equals(userAnswer)) result.setPercentage(100);
        }
        else if (question.getQuestionType() == QuestionType.MULTIANSWER)
        {
            int userCorrectAnswers = 0;
            for (Answer availableAnswer : availableAnswers)
            {
                if ((availableAnswer.getIsCorrect() && Arrays.binarySearch(userAnswers, availableAnswer) >= 0) ||
                    (!availableAnswer.getIsCorrect() && Arrays.binarySearch(userAnswers, availableAnswer) < 0))
                {
                    userCorrectAnswers++;
                }
                else userCorrectAnswers--;
            }

            result.setPercentage(Integer.max(userCorrectAnswers*100 / availableAnswers.size(), 0));
        }
        else if (question.getQuestionType() == QuestionType.SINGLEANSWER)
        {
            if (correctAnswers.size() != 1) {
                throw new Exception(String.format("The question %d has multiple correct answers while question type is %s!", question.getId(), question.getQuestionType().toString()));
            }
            if (userAnswers.length != 1) {
                throw new Exception(String.format("User answered with multiple answers while question type is %s!", question.getQuestionType().toString()));
            }

            Answer correctAnswer = correctAnswers.get(0);
            Answer userAnswer = userAnswers[0];

            if (correctAnswer.equals(userAnswer)) result.setPercentage(100);
        }
        else
        {
            // question type is not supported
        }
        return result;
    }
}
