package com.jrquiz.service.quizvalidation;

import com.jrquiz.entity.Answer;
import com.jrquiz.entity.Question;

import java.util.Map;

public class TestValidator {
    public static TestValidationResult validate(Map<Question, Answer[]> userAnswers) throws Exception {
        TestValidationResult result = new TestValidationResult();
        Integer totalPercentage = 0;
        for (Question question : userAnswers.keySet())
        {
            QuestionValidationResult questionValidationResult = QuestionValidator.validateQuestion(question, userAnswers.get(question));

            totalPercentage += questionValidationResult.getPercentage();
        }
        result.setTotalPercentage(totalPercentage / userAnswers.size());

        return result;
    }

}
