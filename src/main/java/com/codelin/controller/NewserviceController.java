package com.codelin.controller;
import com.codelin.entity.Newservice;
import com.codelin.service.NewserviceService;
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
 * @create 2020-09-11 9:17
 */
@Controller
@RequestMapping("/server")
public class NewserviceController {

    @Autowired
    private NewserviceService newserviceService;

    @GetMapping("/toadd")
    public String toadd(){
        return "/service/servicecreate";
    }

    @PostMapping("/add")
    public String add(HttpServletRequest request){
        Newservice newservice = new Newservice();
        String id = request.getParameter("id");
        int i = Integer.parseInt(id);
        newservice.setId(i);
        newservice.setClientname(request.getParameter("clientname"));
        newservice.setType(request.getParameter("type"));
        newservice.setOutline(request.getParameter("outline"));
        newservice.setStatus(request.getParameter("status"));
        newservice.setCreateperson(request.getParameter("createperson"));
        newservice.setRequest(request.getParameter("request"));
        newservice.setDealperson(request.getParameter("dealperson"));
        String date = request.getParameter("createtime");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date.replaceAll("T", " ") + ":11", df);
        Date date1 = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        newservice.setCreatetime(date1);
        newserviceService.add(newservice);
        System.out.println(newservice);
        return "redirect:/server/findAll";
    }

    @GetMapping("/findAll")
    public String findAll(Model model){
        List<Newservice> list = newserviceService.findAll();
        model.addAttribute("list", list);
        return "/service/servicepush";
    }

}
