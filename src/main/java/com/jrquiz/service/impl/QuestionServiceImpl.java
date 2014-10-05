package com.jrquiz.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.jrquiz.entity.Answer;
import com.jrquiz.entity.Question;
import com.jrquiz.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Override
	public Question addQuestion(Question question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question getQuestion(Long questionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Answer> getAnswers(Long questionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeQuestion(Long id) {
		// TODO Auto-generated method stub

	}

	// @Autowired
	// private QuestionRepository questionRepository;
	//
	// @Override
	// public Question addQuestion(Question question) {
	// return questionRepository.saveAndFlush(question);
	// }
	//
	// @Override
	// public List<Question> getAllQuestions() {
	// return questionRepository.findAll();
	// }
	//
	// @Override
	// public Question updateQuestion(Question question) {
	// return questionRepository.saveAndFlush(question);
	// }
	//
	// @Override
	// public Question getQuestion(Long id) {
	// return questionRepository.findOne(id);
	// }
	//
	// @Override
	// public Set<Answer> getAnswers(Long questionId) {
	// return questionRepository.findOne(questionId).getAnswers();
	// }
	//
	// @Override
	// public void removeQuestion(Long id) {
	// Question question = getQuestion(id);
	// question.setTags(null);
	// questionRepository.saveAndFlush(question);
	// questionRepository.delete(id);
	// }
}
