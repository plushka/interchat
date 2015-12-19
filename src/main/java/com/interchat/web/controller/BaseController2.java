package com.interchat.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/second")
public class BaseController2 {
    private static int counter = 0;
    private static final String VIEW_INDEX = "index";
    private final static Logger logger = LoggerFactory.getLogger(BaseController2.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {
        model.addAttribute("message", "Welcome2");
        model.addAttribute("counter", ++counter);
        logger.debug("[welcome] counter : {}", counter);

        return VIEW_INDEX;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String welcomeName(@PathVariable String name, ModelMap model) {
        model.addAttribute("message", "Welcome2, " + name + "!");
        model.addAttribute("counter", ++counter);
        logger.debug("[welcomeName] counter: {}", counter);
        return VIEW_INDEX;
    }

}
