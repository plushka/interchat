package com.interchat.dao;

import com.interchat.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;



    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User")
                .list();
    }

    public void removeUser(Integer id) {
        User user = sessionFactory.getCurrentSession().load(
                User.class, id);
        if (null != user) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    public User findByEmail(String email) {
        List users = sessionFactory.getCurrentSession().createQuery("from User where email = '" + email + "'")
                .list();
        if (CollectionUtils.isEmpty(users)) return null;
        return (User) users.get(0);
    }

}
