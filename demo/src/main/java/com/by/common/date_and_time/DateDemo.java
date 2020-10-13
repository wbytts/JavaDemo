package com.by.common.date_and_time;

import org.junit.Test;

import java.util.Date;

public class DateDemo {

    @Test
    public void test01() {
        Date date = new Date();

        // Tue Oct 13 17:32:24 GMT+08:00 2020
        System.out.println(date);

        /* Date 对象的一些属性和方法 */
        // Date 对象的构造方法
        Date d1 = new Date(); // 默认构造方法，产生当前时间对应的Date对象
        Date d2 = new Date("2020-10-10");
        // 获得date对象日期对应的时间戳
        System.out.println(date.getTime());
        // 其他方法一般都不推荐使用了
    }

}
