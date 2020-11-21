package com.by.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTools {

    /**
     * 按 yyyy-MM-dd HH:mm:ss 样式获取当前日期
     * @return
     */
    public static String getDateYMD$HMS() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /**
     * 按 yyyyMMdd 样式获取当前日期
     * @return
     */
    public static String getDateYMDHMS() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    /**
     * 时间精确到毫秒
     * @return
     */
    public static String getCkDateMini() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    }

    /**
     * 按yyyyMM样式获取当前日期
     * @return
     */
    public static String getMonth() {
        return new SimpleDateFormat("yyyyMM").format(new Date());
    }

    /**
     * 根据样式获取当前日期
     * @param format
     * @return
     */
    public static String getDate(String format) {
        return new SimpleDateFormat(format).format(new Date());
    }

    /**
     *
     * 方法描述
     *
     * @param strDate
     *            时间的字符串
     * @param pattern
     *            时间格式
     * @param days
     *            天数
     * @return 指定天数加上指定天数的时间的字符串格式
     */
    public static String AddDay(String strDate,String pattern,int days){
        if(strDate == null || "".equals(strDate) || pattern == null || "".equals(pattern) || strDate.length() < pattern.length()){
            return null;
        }
        String resultDate = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            Date date = dateFormat.parse(strDate.substring(0,pattern.length()));
            Calendar cale = Calendar.getInstance();
            cale.setTime(date);
            // 指定时间内加上指定天数
            cale.add(Calendar.DAY_OF_MONTH, days);
            date = cale.getTime();
            // 结果时间的字符串格式
            resultDate = dateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultDate;
    }

    /**
     * 天数。向前
     * @param d
     * @param days
     * @return
     */
    public static Date backwordDay(Date d, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.DATE, -days);
        return calendar.getTime();
    }

    /**
     * 天数，向后
     * @param d
     * @param days
     * @return
     */
    public static Date forwordDay(Date d, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    /**
     * 月份，向前
     * @param d
     * @param months
     * @return
     */
    public static Date backwordMonth(Date d, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.MONTH, -months);
        return calendar.getTime();
    }

    /**
     * 月份，向后
     * @param d
     * @param months
     * @return
     */
    public static Date forwordMonth(Date d, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.MONTH, months);
        return calendar.getTime();
    }

    /**
     * 年份，向前
     * @param d
     * @param years
     * @return
     */
    public static Date backwordYear(Date d, int years) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.YEAR, -years);
        return calendar.getTime();
    }

    /**
     * 年份，向后
     * @param d
     * @param years
     * @return
     */
    public static Date forwordYear(Date d, int years) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.YEAR, years);
        return calendar.getTime();
    }

    /**
     * 解析 yyyy-MM-dd HH:mm:ss 格式的日期字符串
     * @param DateStr
     * @return
     */
    public static Date parseYMDHMS(String DateStr){
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(DateStr);
        } catch (ParseException e) {
            // logger.error("日期解析失败,传入字符串不是标准的字符串格式。");
            return null;
        }
    }

    /**
     * 解析 yyyy-MM-dd 格式的日期字符串
     * @param DateStr
     * @return
     */
    public static Date parseYMD(String DateStr){
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(DateStr);
        } catch (ParseException e) {
            // logger.error("日期解析失败,传入字符串不是标准的字符串格式。");
            return null;
        }
    }

    /*
     * 计算两个日期相差的月份
     */
    public static int getDateSpace(Date date1,Date date2){
        int result = 0;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(date1);
        c2.setTime(date2);

        result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
        int mouth = (c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR)) * 12;

        return result == 0 ? 1 : Math.abs(mouth+result);
    }

    /**
     * 计算两个日期的相隔天数
     * @author
     * @param date1
     * @param date2
     * @return
     */
    public static int daysBetween(Date date1, Date date2) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }
}
