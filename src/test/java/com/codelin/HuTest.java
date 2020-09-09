package com.codelin;


import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;

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
}
