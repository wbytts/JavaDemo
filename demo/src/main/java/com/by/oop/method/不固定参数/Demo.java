package com.by.oop.method.不固定参数;

/**
 * 结尾不固定参数
 * @author bingyi
 */
public class Demo {
    public static void main(String[] args) {
        fun("111", "123123", "hello", "qwesss");
    }

    public static void fun(String ...vals) {
        for(String val : vals) {
            System.out.println(val);
        }
    }
}
