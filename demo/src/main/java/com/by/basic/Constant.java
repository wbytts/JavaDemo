package com.by.basic;

/**
 * 常量的分类：
 *      * 字符串常量：凡是用双引号包起来的，叫做字符串常量
 *      * 整数常量：直接写上的数字，没有小数点
 *      * 浮点数常量：直接写上的数字，有小数点
 *      * 字符常量：凡是用单引号引起来的单个字符，叫做字符常量
 *      * 布尔常量：true、false
 *      * 空常量：null  代表没有任何数据
 */
public class Constant {
    public static void main(String[] args) {
        // 字符串常量
        System.out.println("ABC");
        System.out.println("");
        System.out.println("XYZ");

        // 整数常量
        System.out.println(123);
        System.out.println(-20);

        // 浮点数常量
        System.out.println(1.234);
        System.out.println(-2.5);

        // 字符常量
        System.out.println('A');
        System.out.println('6');
        //System.out.println(''); // 单引号中必须有且仅有一个字符
        //System.out.println('AB'); // 单引号中必须有且仅有一个字符

        // 布尔常量
        System.out.println(true);
        System.out.println(false);

        // 空常量
        // System.out.println(null); // 空常量不能用来打印输出
    }
}
