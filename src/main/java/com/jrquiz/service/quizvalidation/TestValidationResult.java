package com.jrquiz.service.quizvalidation;

import java.util.ArrayList;

/**
 * Created by Andrew Kostenko on 2014-09-17.
 */
public class TestValidationResult extends ArrayList<QuestionValidationResult> {
    private Integer totalPercentage;

    public Integer getTotalPercentage() {
        return totalPercentage;
    }

    void setTotalPercentage(Integer totalPercentage) {
        this.totalPercentage = totalPercentage;
    }
}
