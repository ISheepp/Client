package com.codelin.service;

import com.codelin.entity.User;

public interface UserService {

    void register(User user);

    User login(String username, String password);
}
