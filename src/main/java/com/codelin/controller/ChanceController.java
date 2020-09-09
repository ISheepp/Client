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

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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
    public String addChance(Chance chance, HttpServletRequest request) {
        String date = request.getParameter("createtime");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date.replaceAll("T", " ") + ":00", df);
        //chance.setCreatetime(dateTime);
        chanceService.addChance(chance);
        return "market/data-table";
    }

}
