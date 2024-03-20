package com.example.springcource.dao;

import com.example.springcource.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    void saveUser(User user);

    User getUser(long id);

    void deleteUser(long id);
}
