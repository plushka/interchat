package com.interchat.web.controller;

import com.interchat.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/rest")
public class RestController {

    @RequestMapping("/resource")
    public Map<String, Object> home() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World 12345");
        return model;
    }

    @RequestMapping("/user")
    public User user(User user) {

        User testUser = new User();
        testUser.setName("TestName");
        return testUser;
    }
}
