package com.codelin.controller;

import com.codelin.entity.User;
import com.codelin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //注册方法
    @PostMapping("/register")
    public String register(User user){
        userService.register(user);
        return "redirect:/index";
    }
}
