package com.jrquiz.service.quizvalidation;

import com.jrquiz.entity.Question;

/**
 * Created by Andrew on 2014-09-17.
 */
public class QuestionValidationResult {
    private final Question question;
    private Integer percentage = 0;

    public QuestionValidationResult(Question question) {
        this.question = question;
    }

    public Integer getPercentage() {
        return percentage;
    }

    void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }
}
