package com.codelin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String toindex(){
        return "login";
    }

    @GetMapping("/register")
    public String toregister(){
        return "sign-up";
    }

    @GetMapping("/success")
    public String tosuccess(){
        return "indexto";
    }
}
