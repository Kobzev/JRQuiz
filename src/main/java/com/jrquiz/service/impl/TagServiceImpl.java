package com.jrquiz.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.jrquiz.entity.Question;
import com.jrquiz.entity.Tag;
import com.jrquiz.service.TagService;

@Service
public class TagServiceImpl implements TagService {

	@Override
	public Tag addTag(Tag tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tag> getAllTags() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Question> getAllQuestionsByTags(Set<Tag> tags) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tag getTag(Long tagId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tag getTagByName(String tagName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeTag(Long tagId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Tag updateTag(Tag tag) {
		// TODO Auto-generated method stub
		return null;
	}

	// @Autowired
	// private TagRepository tagRepository;
	//
	// @Override
	// public Tag addTag(Tag tag) {
	//
	// try {
	// return tagRepository.saveAndFlush(tag);
	// }
	// catch (Exception e)
	// {}
	// return getTagByName(tag.getTagName());
	// //TODO Придумать как это лучше реализовать
	// }
	//
	// @Override
	// public List<Tag> getAllTags() {
	// return tagRepository.findAll();
	// }
	//
	// @Override
	// public Set<Question> getAllQuestionsByTags(Set<Tag> tags) {
	// HashSet<Question> questions = new HashSet<>();
	// for(Tag tag: tags)
	// {
	// questions.addAll(tag.getQuestions());
	// }
	// return questions;
	// }
	//
	// @Override
	// @Transactional(propagation = Propagation.REQUIRED)
	// public Tag getTag(Long tagId) {
	// return tagRepository.findOne(tagId);
	// }
	//
	// @Override
	// public Tag getTagByName(String tagName) {
	// return tagRepository.findByTagName(tagName);
	// }
	//
	// @Override
	// public void removeTag(Long tagId){
	// Tag tag = tagRepository.findOne(tagId);
	// if(tag.getQuestions().isEmpty())
	// tagRepository.delete(tagId);
	// else
	// throw new
	// RuntimeException("Tags have associated questions and can not be removed");//TODO
	// исключение временное, потом поменять
	// }
	//
	// @Override
	// public Tag updateTag(Tag tag) {
	// return tagRepository.saveAndFlush(tag);
	// }

}
