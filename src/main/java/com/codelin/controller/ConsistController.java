package com.codelin.controller;

import com.codelin.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lin
 * @create 2020-09-11 14:14
 */

@Controller
@RequestMapping("/consist")
public class ConsistController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/consist")
    public String consist(Model model){
        int i = clientService.find1();
        model.addAttribute("i",i);
        return "/statis/tongjiconsist";
    }

}
