package com.codelin.controller;

import com.codelin.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lin
 * @create 2020-09-10 15:07
 */

@Controller
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    PlanService planService;

    @GetMapping("/findAll")
    public String findAll(String clientname, Model model){
        planService.findByClientName(clientname);
        model.addAttribute("client", clientname);
        return "/market/zhidingjihua";
    }
}
