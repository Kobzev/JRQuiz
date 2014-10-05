package com.jrquiz.controller;

import com.jrquiz.entity.Test;
import com.jrquiz.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Михаил on 27.09.2014.
 */

@Controller
public class TestGeneratorController {

    @Autowired
    TagService tagService;

    private static Test test;

    //dummy

    @RequestMapping("/test")
    public String showAllTags(ModelMap model) {
        model.addAttribute("allTags", tagService.getAllTags());
        return "test/testGenerator";

    }

    @RequestMapping("/showtest")
    public String showTest(ModelMap model) {
        return "test/testShow";

    }
}
