package com.codelin.service;

import com.codelin.entity.User;

import java.util.List;

public interface UserService {

    void register(User user);

    User login(String username, String password);

    List<User> findAll();

    User findById(String id);

    void update(User user);
}
