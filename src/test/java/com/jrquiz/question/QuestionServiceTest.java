package com.jrquiz.question;


import com.jrquiz.entity.Question;
import com.jrquiz.entity.enums.QuestionType;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.*;

public class QuestionServiceTest extends EntityAndServiceBaseTest {

    private String questionTitle = "Test ADD Question";
    private String questionText = "Test ADD Question";

    @Test
    public void addQuestionTest() throws Exception {
        Question question = new Question();
        question.setQuestionType(QuestionType.MULTIANSWER);
        question.setTitle(questionTitle);
        question.setText(questionText);
        Question newQuestion = questionService.addQuestion(question);
        Long id = newQuestion.getId();
        Question checkedQuestion = questionService.getQuestion(id);
        assertEquals("Question added successfully", checkedQuestion.getTitle(), questionTitle);
        questionService.removeQuestion(id);
    }

    @Test
    public void removeQuestionTest() throws Exception {
        Question question = new Question();
        question.setQuestionType(QuestionType.MULTIANSWER);
        question.setTitle(questionTitle);
        question.setText(questionText);
        Question newQuestion = questionService.addQuestion(question);
        Long id = newQuestion.getId();
        questionService.removeQuestion(id);
        Question deletedQuestion = questionService.getQuestion(id);
        assertNull(deletedQuestion);
    }

    @Test
    public void getQuestionTest() throws Exception {
        Question question = new Question();
        question.setQuestionType(QuestionType.MULTIANSWER);
        question.setTitle(questionTitle);
        question.setText(questionText);
        Question newQuestion = questionService.addQuestion(question);
        Long id = newQuestion.getId();
        Question checkedQuestion = questionService.getQuestion(id);
        assertNotNull(checkedQuestion.getTitle());
        questionService.removeQuestion(id);
    }

    @Test
    public void updateQuestion() throws Exception {
        Question question = new Question();
        question.setQuestionType(QuestionType.MULTIANSWER);
        question.setTitle(questionTitle);
        question.setText(questionText);
        Question newQuestion = questionService.addQuestion(question);
        Long id = newQuestion.getId();

        Question questionToUpdate = questionService.getQuestion(id);
        String updatedQuestionTitle = "Updated Question";
        questionToUpdate.setTitle(updatedQuestionTitle);
        questionService.updateQuestion(questionToUpdate);
        Question updatedQuestion = questionService.getQuestion(id);

        assertEquals(updatedQuestionTitle, updatedQuestion.getTitle());
        questionService.removeQuestion(id);
    }
}
