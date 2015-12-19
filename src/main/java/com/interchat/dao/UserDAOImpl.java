package com.interchat.dao;

import com.interchat.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private EntityManager entityManager;


    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        entityManager = emf.createEntityManager();
    }

    public void addUser(User user) {
        entityManager.persist(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return entityManager.
                createQuery("from Users").getResultList();
    }

    public void removeUser(Integer id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

}
