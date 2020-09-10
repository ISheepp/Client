package com.codelin.controller;

import cn.hutool.core.date.DateUtil;
import com.codelin.entity.Chance;
import com.codelin.service.ChanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        LocalDateTime dateTime = LocalDateTime.parse(date.replaceAll("T", " ") + ":00", df);
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
        model.addAttribute("new", newChance);
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
        LocalDateTime dateTime = LocalDateTime.parse(date.replaceAll("T", " ") + ":00", df);
        Date date1 = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        chance.setCreatetime(date1);
        chanceService.update(chance);
        return "redirect:/market/findAll";
    }

}
