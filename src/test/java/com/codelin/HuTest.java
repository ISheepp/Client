package com.codelin;


import cn.hutool.core.date.DateUtil;
import com.codelin.entity.Chance;
import org.apache.xerces.dom.ChildNode;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * @author lin
 * @create 2020-09-09 9:47
 */
public class HuTest {
    @Test
    public void testHutool(){
        //当前时间
        Date date = DateUtil.date();
        //当前时间
        Date date2 = DateUtil.date(Calendar.getInstance());
        //当前时间
        Date date3 = DateUtil.date(System.currentTimeMillis());
        String now = DateUtil.now();
        System.out.println(now);
        System.out.println(date);
        System.out.println(date2);
        System.out.println(date3);
    }

    @Test
    public void StrToDate(){
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        System.out.println("Date = " + date);
        System.out.println("LocalDateTime = " + localDateTime);
    }
}
