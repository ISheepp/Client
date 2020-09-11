package com.codelin.controller;

import com.codelin.entity.Client;
import com.codelin.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/findAll")
    public String findAll(Model model){
        List<Client> list = clientService.findAll();
        model.addAttribute("client", list);
        return "/client/clientInfo";
    }

    @GetMapping("/show")
    public String findById(int id, Model model){
        Client one = clientService.findById(id);
        model.addAttribute("client", one);
        return "/client/clientInfoShow";
    }

    @GetMapping("/toadd")
    public String toAdd(){
        return "client/addclientInfo";
    }

    @PostMapping("/add")
    public String add(Client client){
        clientService.add(client);
        return "redirect:/client/findAll";
    }

    @GetMapping("/delete")
    public String delete(int id){
        clientService.delete(id);
        return "redirect:/client/findAll";
    }

    @GetMapping("/find")
    public String find(int id, Model model){
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        return "/client/clientInfochange";
    }

    @PostMapping("/update")
    public String update(Client client){
        clientService.update(client);
        return "redirect:/client/findAll";
    }

    @GetMapping("/consist")
    public String consist(Model model){
        int i = clientService.find1();
        int j = clientService.find2();
        int k = clientService.find3();
        int l = clientService.find4();
        model.addAttribute("i",i);
        model.addAttribute("j",j);
        model.addAttribute("k",k);
        model.addAttribute("l",l);
        return "/statis/tongjiconsist";
    }

}
