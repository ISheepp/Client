package com.codelin.dao;

import com.codelin.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    //用户注册
    void save(User user);

    //用户登录
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
