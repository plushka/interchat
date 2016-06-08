package com.interchat.dao;

import com.interchat.domain.User;

import java.util.List;

public interface UserDAO {

    void addUser(User user);

    List<User> listUsers();

    void removeUser(Integer id);

    User findByEmail(String email);

}
