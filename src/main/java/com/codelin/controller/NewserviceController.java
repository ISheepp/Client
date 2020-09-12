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

    @GetMapping("/consist")
    public String consist(Model model){
        int i = newserviceService.find1();
        int j = newserviceService.find2();
        int k = newserviceService.find3();
        int l = newserviceService.find4();
        model.addAttribute("i",i);
        model.addAttribute("j",j);
        model.addAttribute("k",k);
        model.addAttribute("l",l);
        return "/statis/tongjiservice";
    }

    @PostMapping("/update")
    public String update(int id){
        newserviceService.update(id);
        return "redirect:/server/findAll";
    }

    @GetMapping("/delete")
    public String delete(int id){
        newserviceService.delete(id);
        return "redirect:/server/findAll";
    }

    @GetMapping("/doing")
    public String doing(Model model){
        List<Newservice> list = newserviceService.findByStatus();
        model.addAttribute("list", list);
        return "/service/servicedoing";
    }

    @GetMapping("/archive")
    public String archive(int id){
        newserviceService.archive(id);
        return "redirect:/server/doing";
    }

    @GetMapping("/done")
    public String done(Model model){
        List<Newservice> list = newserviceService.done();
        model.addAttribute("list", list);
        return "/service/servicedone";
    }

}
