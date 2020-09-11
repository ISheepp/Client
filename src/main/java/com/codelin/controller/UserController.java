package com.codelin.controller;

import com.codelin.entity.User;
import com.codelin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    //用户登录
    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        User user = userService.login(username, password);
        if (user != null){
            session.setAttribute("user",user);
            return "redirect:/success";
        }
        else {
            return "redirect:/index";
        }
    }

    @GetMapping("/findAll")
    public String findAll(Model model){
        List<User> list = userService.findAll();
        model.addAttribute("list", list);
        return "/users/userlist";
    }

    @GetMapping("/findById")
    public String findById(String id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "/users/usermanage";
    }

    @PostMapping("/update")
    public String update(User user){
        userService.update(user);
        return "redirect:/user/findAll";
    }

}
