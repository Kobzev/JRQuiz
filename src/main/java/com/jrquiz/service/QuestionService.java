package com.jrquiz.service;


import com.jrquiz.entity.Answer;
import com.jrquiz.entity.Question;

import java.util.List;
import java.util.Set;

public interface QuestionService {
    Question addQuestion(Question question);

    List<Question> getAllQuestions();

    Question updateQuestion(Question question);

    Question getQuestion(Long questionId);

    Set<Answer> getAnswers(Long questionId);

    void removeQuestion(Long id);
}
