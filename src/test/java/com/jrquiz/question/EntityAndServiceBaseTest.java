package com.jrquiz.question;

import com.jrquiz.config.DataConfigForTest;
import com.jrquiz.entity.Answer;
import com.jrquiz.entity.Question;
import com.jrquiz.entity.Tag;
import com.jrquiz.entity.User;
import com.jrquiz.entity.enums.QuestionType;
import com.jrquiz.service.QuestionService;
import com.jrquiz.service.TagService;
import com.jrquiz.service.TestService;
import com.jrquiz.service.UserService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.HashSet;

import static junit.framework.TestCase.assertNull;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfigForTest.class)
@WebAppConfiguration
public class EntityAndServiceBaseTest {
    @Resource
    protected EntityManagerFactory emf;

    protected EntityManager em;

    @Resource
    protected QuestionService questionService;

    @Resource
    protected TagService tagService;

    @Resource
    protected UserService userService;

    @Resource
    protected TestService testService;

    @Test
    public void CreateTestData() {
        em = emf.createEntityManager();

        //create 5 users
        int sizeOfUsers = 5;
        String[] userNames = {"Valera", "Andrey", "Zhora", "Dima", "Petya"};
        User[] users = new User[sizeOfUsers];
        for (int i = 0; i < sizeOfUsers; i++) {
            User user = new User();
            user.setUserName(userNames[i]);
            users[i] = userService.addUser(user);
        }

        //create 5 tags
        int sizeOfTags = 5;
        String tagName = "testtag";
        HashSet<Tag> tags = new HashSet<>();
        for (int i = 0; i < sizeOfTags; i++) {
            Tag tag = new Tag();
            tag.setTagName(tagName + i);
            tagService.addTag(tag);
            tags.add(tagService.addTag(tag));
        }

        //create Questions
        int sizeOfQuestions = 5;
        QuestionType[] questionTypes = QuestionType.values();
        String questionTitle = "Question Title #";
        String questionText = "Question Text #";
        String answerText = "answer #";
        for (int i = 0; i < sizeOfQuestions; i++) {

            Question question = new Question();
            QuestionType questionType = questionTypes[i % 3];
            HashSet<Answer> answers = new HashSet<>();
            if (questionType.equals(QuestionType.MULTIANSWER)) {
                for (int j = 0; j < 4; j++) {
                    Answer answer = new Answer();
                    answer.setAnswerText(answerText + j + " of question" + i);
                    Boolean isCorrect = (((i + 1) * (j + 1)) % 2 == 0);
                    answer.setIsCorrect(isCorrect);
                    answer.setQuestion(question);
                    answers.add(answer);
                }
            } else if (questionType.equals(QuestionType.SINGLEANSWER)) {
                for (int j = 0; j < 4; j++) {
                    Answer answer = new Answer();
                    answer.setAnswerText(answerText + j + " of question" + i);
                    Boolean isCorrect = (j == 0);
                    answer.setIsCorrect(isCorrect);
                    answer.setQuestion(question);
                    answers.add(answer);
                }
            } else {
                Answer answer = new Answer();
                answer.setAnswerText(answerText + 1 + " of question" + i);
                answer.setIsCorrect(true);
                answer.setQuestion(question);
                answers.add(answer);
            }

            question.setQuestionType(questionType);
            question.setTitle(questionTitle + i);
            question.setText(questionText + i);
            question.setCreatedBy(users[i % sizeOfUsers]);
            question.setAnswers(answers);
            question.setTags(tags);
            questionService.addQuestion(question);
        }


        com.jrquiz.entity.Test test = new com.jrquiz.entity.Test();
        test.setQuestions(new HashSet<Question>());
        test.getQuestions().addAll(questionService.getAllQuestions());
        testService.addTest(test);

    }


}
