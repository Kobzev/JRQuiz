package com.jrquiz.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.jrquiz.entity.Question;
import com.jrquiz.entity.Tag;
import com.jrquiz.entity.Test;
import com.jrquiz.entity.User;
import com.jrquiz.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Override
	public Test getTest(Long testID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Question> getQuestions(Long testID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Test addTest(Test test) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Test> getTestsByTag(Tag tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Test> getTestsByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Test updateTest(Test test) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeTest(Long testID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTest(Test entity) {
		// TODO Auto-generated method stub

	}
	// @Autowired
	// private TestRepository testRepository;
	//
	// @Override
	// public Test getTest(Long testID) {
	// return testRepository.findOne(testID);
	// }
	//
	// @Override
	// public Set<Question> getQuestions(Long testID) {
	// return testRepository.findOne(testID).getQuestions();
	// }
	//
	// @Override
	// public Test addTest(Test test) {
	// return testRepository.saveAndFlush(test);
	// }
	//
	// @Override
	// public List<Test> getTestsByTag(Tag tag) {
	// // TODO implement
	// return null;
	// }
	//
	// @Override
	// public List<Test> getTestsByUser(User user) {
	// // TODO implement
	// return null;
	// }
	//
	// @Override
	// public Test updateTest(Test test) {
	// return testRepository.saveAndFlush(test);
	// }
	//
	// @Override
	// public void removeTest(Long testID) {
	// testRepository.delete(testID);
	// }
	//
	// @Override
	// public void removeTest(Test entity) {
	// testRepository.delete(entity);
	// }
}
