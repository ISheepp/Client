package com.codelin.controller;

import com.codelin.entity.Plan;
import com.codelin.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

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
        List<Plan> name = planService.findByClientName(clientname);
        model.addAttribute("client", name);
        return "/market/zhidingjihua";
    }

    @GetMapping("/delete")
    public String delete(int id){
        planService.delete(id);
        return "redirect:/market/all";
    }

    @PostMapping("/add")
    public String add(HttpServletRequest request){
        Plan plan = new Plan();

        plan.setClientname(request.getParameter("clientname"));
        plan.setItem(request.getParameter("item"));
        String date = request.getParameter("date");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date.replaceAll("T", " ") + ":11", df);
        Date date1 = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        plan.setDate(date1);
        planService.add(plan);
        return "redirect:/market/all";
    }

}
