package com.by.hutool.core_demo.date_demo;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import org.junit.Test;

import java.util.Date;


/**
 * Hutool 日期相关方法测试与用例
 */
public class HutoolDateTest {

    /**
     * HT: 将时间字符串转换成Date对象，不用说明日期格式，直接写就行，会自动匹配最合适的进行解析
     * 支持的格式有：
     * <li>yyyy-MM-dd HH:mm:ss</li>
     * <li>yyyy/MM/dd HH:mm:ss</li>
     * <li>yyyy.MM.dd HH:mm:ss</li>
     * <li>yyyy年MM月dd日 HH时mm分ss秒</li>
     * <li>yyyy-MM-dd</li>
     * <li>yyyy/MM/dd</li>
     * <li>yyyy.MM.dd</li>
     * <li>HH:mm:ss</li>
     * <li>HH时mm分ss秒</li>
     * <li>yyyy-MM-dd HH:mm</li>
     * <li>yyyy-MM-dd HH:mm:ss.SSS</li>
     * <li>yyyyMMddHHmmss</li>
     * <li>yyyyMMddHHmmssSSS</li>
     * <li>yyyyMMdd</li>
     * <li>EEE, dd MMM yyyy HH:mm:ss z</li>
     * <li>EEE MMM dd HH:mm:ss zzz yyyy</li>
     * <li>yyyy-MM-dd'T'HH:mm:ss'Z'</li>
     * <li>yyyy-MM-dd'T'HH:mm:ss.SSS'Z'</li>
     * <li>yyyy-MM-dd'T'HH:mm:ssZ</li>
     * <li>yyyy-MM-dd'T'HH:mm:ss.SSSZ</li>
     */
    @Test public void test_解析日期字符串() {
        Date date = DateUtil.parse("2020-09-02");
        System.out.println(date);

        System.out.println(DateUtil.parse("2020-09-02 18:07"));
        System.out.println(DateUtil.parse("2020/09/02 18:07"));
        System.out.println(DateUtil.parse("2020年09月02日 18:07"));
    }

}
