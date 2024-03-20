package com.example.springcource.dao;

import com.example.springcource.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImp implements UserDao {


    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUser(long id) {
        TypedQuery<User> q = (TypedQuery<User>) entityManager
                .createQuery("SELECT u FROM User u WHERE u.id=:id").setParameter("id", id);
        return q.getSingleResult();
    }

    @Override
    public void deleteUser(long id) {
        entityManager.createQuery("delete from User " + "where id=:userId")
                .setParameter("userId", id).executeUpdate();
    }
}
