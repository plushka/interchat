package com.interchat.service;

import com.interchat.domain.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> listUsers();

    void removeUser(Integer id);

    User findByEmail(String email);

}
