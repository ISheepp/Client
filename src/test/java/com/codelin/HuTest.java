package com.codelin;


import cn.hutool.core.date.DateUtil;
import com.codelin.entity.Chance;
import org.apache.xerces.dom.ChildNode;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RequestMapping;

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
        Chance chance = new Chance();
        String str = "12412341";
        Date date = DateUtil.parse(str);
        chance.setCreatetime(date);
        System.out.println(chance.getCreatetime());
    }
}
