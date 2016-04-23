package com.interchat.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/rest")
public class RestController {

    private final static Logger logger = LoggerFactory.getLogger(BaseController.class);

    @RequestMapping("/resource")
    public Map<String, Object> home() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World 12345");
        return model;
    }

    @RequestMapping("/user")
    public Principal user(Principal credentials) {
        logger.debug("User name = " + credentials);
//        User testUser = new User();
//        testUser.setName("TestName");
        return credentials;
    }
}
