package com.by.basic;

/**
 * 变量：程序运行期间，内容可以改变的量
 *
 * 创建一个变量并使用
 *
 * 数据类型 变量名称;  // 创建了一个变量
 * 变量名称 = 变量值;
 *
 * 数据类型 变量名称 = 变量值;
 * 数据类型 变量1, 变量2, 变量3;
 * 数据类型 变量1, 变量2 = 值, 变量3;
 * ...
 *
 * 变量使用的注意事项：
 *      1. 对于float和long类型，用字面量赋值，不要忘记 F 和 L
 *      2. 没有进行赋值的变量不能直接使用
 *      3. 变量名不能重复
 *      4. 变量赋值不能超过变量的存储范围
 *      5. 变量的使用不能超过作用域的范围
 *              作用域：定义开始到最近的大括号为止
 */
public class Variable {
    public static void main(String[] args) {
        // 定义一个int型的变量 a1
        int a1;
        // 给变量a1赋值
        a1 = 3;
        System.out.println("a1=" + a1);

        // 定义一个int型的变量a2，并赋值
        int a2 = 4;
        System.out.println("a2=" + a2);

        // 定义一个byte型的变量b，并赋值
        byte b = 5;
        System.out.println("b=" + b);

        // 定义一个short类型的变量，并赋值
        short s = 6;
        System.out.println("s=" + s);

        // 定义一个long类型的变量l
        long l = 7;
        System.out.println("l=" + l);

        //long l2 = 999999999999999999; // 直接这么写会报错
        long l2 = 999999999999999999L; // long类型的常量后面要加 L 或者 l
        System.out.println("l2=" + l2);

        float f = 3.14F; // 小数默认是double类型，所以float的常量要加一个 f 或者 F 来表示
        System.out.println("f=" + f);

        // 定义一个double类型变量
        double d = 1.2;
        System.out.println("d=" + d);

        // 字符类型
        char c1 = 'A'; // 单个字符
        char c2 = '\t'; // 转义字符
        char c3 = '我'; // java的char是两个字节，可以存储汉字
        char c4 = '\u66f9'; // 直接使用Unicode值表示字符型的常量
        char c5 = 96; // char也可以直接接受整型值

        // 布尔类型
        boolean flag1 = true;
        boolean flag2 = false;
        System.out.println("flag1=" + flag1);
        System.out.println("flag2=" + flag2);

    }
}
