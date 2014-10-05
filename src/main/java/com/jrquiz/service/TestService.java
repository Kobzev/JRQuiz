package com.jrquiz.service;

import com.jrquiz.entity.Question;
import com.jrquiz.entity.Tag;
import com.jrquiz.entity.Test;
import com.jrquiz.entity.User;

import java.util.List;
import java.util.Set;

public interface TestService {
    Test getTest(Long testID);
    Set<Question> getQuestions(Long testID);

    Test addTest(Test test);

    List<Test> getTestsByTag(Tag tag);
    List<Test> getTestsByUser(User user);

    Test updateTest(Test test);

    void removeTest(Long testID);
    void removeTest(Test entity);
}
