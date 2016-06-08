package com.interchat.service;

import com.interchat.dao.UserDAO;
import com.interchat.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    public void removeUser(Integer id) {
        userDAO.removeUser(id);
    }

    @Override
    public User findByEmail(String email) {
        return userDAO.findByEmail(email);
    }
}
