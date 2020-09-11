package com.codelin.dao;

import com.codelin.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface UserDao {

    //用户注册
    void save(User user);

    //用户登录
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    //查询所有
    List<User> findAll();

    //根据id查询
    User findById(String id);

    //更新
    void update(User user);
}
