package com.jrquiz.controller;


import com.jrquiz.entity.Question;
import com.jrquiz.entity.Tag;
import com.jrquiz.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Set;

@Controller

@RequestMapping(value = "/tags")
public class TagController {

    @Autowired
    TagService tagService;

    @RequestMapping(method = RequestMethod.POST)
    public String addTag (@Valid Tag tag, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "tag/tags";
        }
        tagService.addTag(tag);
        return "redirect:tags";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showTags(Model model) {
        model.addAttribute("tag", new Tag());
        model.addAttribute("allTags", tagService.getAllTags());
        return "tag/tags";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String ediTag(@RequestParam(value = "id", defaultValue = "1") Long id, Model model) {

        Tag tag = tagService.getTag(id);
        model.addAttribute("tagToEdit", tag);

        Set<Question> questions = tag.getQuestions();
        model.addAttribute("questionsForTag", questions);
        return "tag/editTag";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String ediTag(@Valid Tag tagToEdit, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "tag/tags";
        }
        tagService.addTag(tagToEdit);
        return "redirect:/tags";
    }
}
