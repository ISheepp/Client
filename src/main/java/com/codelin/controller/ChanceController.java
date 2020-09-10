package com.codelin.controller;


import com.codelin.entity.Chance;
import com.codelin.service.ChanceService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import javax.servlet.http.HttpServletRequest;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/market")
public class ChanceController {

    @Autowired
    private ChanceService chanceService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Chance> list = chanceService.findAll();
        model.addAttribute("chance", list);
        return "market/data-table";
    }

    @RequestMapping("/addchance")
    public String toAddChance() {
        return "market/add-chance";
    }

    //添加
    @PostMapping("/add")
    public String addChance(HttpServletRequest request) {
        Chance chance = new Chance();
        String id = request.getParameter("id");
        int i = Integer.parseInt(id);
        chance.setId(i);
        chance.setClientname(request.getParameter("clientname"));
        chance.setOutline(request.getParameter("outline"));
        chance.setPerson(request.getParameter("person"));
        chance.setPhone(request.getParameter("phone"));
        chance.setCreateperson(request.getParameter("createperson"));
        chance.setSource(request.getParameter("source"));
        chance.setSuccess(request.getParameter("success"));
        String date = request.getParameter("createtime");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date.replaceAll("T", " ") + ":11", df);
        Date date1 = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        chance.setCreatetime(date1);
        chanceService.addChance(chance);
        return "redirect:/market/findAll";
    }

    //删除
    @GetMapping("/delete")
    public String deleteChance(int id){
        chanceService.deleteChance(id);
        return "redirect:/market/findAll";
    }

    //根据id查询
    @GetMapping("/find")
    public String find(int id, Model model){

        Chance newChance = chanceService.findById(id);
        Date date = newChance.getCreatetime();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        String s = localDateTime.toString();
        model.addAttribute("newChance", newChance);
        model.addAttribute("newTime", s);
        System.out.println(newChance);
        System.out.println(s);
        return "/market/form-validation";
    }

    //更新
    @PostMapping("/update")
    public String update(HttpServletRequest request){
        Chance chance = new Chance();
        String id = request.getParameter("id");
        int i = Integer.parseInt(id);
        chance.setId(i);
        chance.setClientname(request.getParameter("clientname"));
        chance.setOutline(request.getParameter("outline"));
        chance.setPerson(request.getParameter("person"));
        chance.setPhone(request.getParameter("phone"));
        chance.setCreateperson(request.getParameter("createperson"));
        chance.setSource(request.getParameter("source"));
        chance.setSuccess(request.getParameter("success"));
        String date = request.getParameter("createtime");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date.replaceAll("T", " "), df);
        Date date1 = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        chance.setCreatetime(date1);
        chanceService.update(chance);
        return "redirect:/market/findAll";
    }

    @GetMapping("/all")
    public String all(Model model){
        List<Chance> list = chanceService.findAll();
        model.addAttribute("plan", list);
        return "market/data-tables";
    }
}
