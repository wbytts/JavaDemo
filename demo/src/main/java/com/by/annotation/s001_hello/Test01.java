package com.by.annotation.s001_hello;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 什么是注解
 * @author bingyi
 */
public class Test01 {
    // @Override 重写的注解
    @Override
    public String toString() {
        return super.toString();
    }

    // @Deprecated 不推荐程序员使用，但是可以使用。
    @Deprecated
    public static void test() {

    }

    // 注解可以显示赋值，如果没有默认值，我们就必须给注解赋值
    @SuppressWarnings("all")
    @MyAnnotation(name = "bingyi")
    public void test2() {
        boolean flag = 3 >= 4;

    }

    public static void main(String[] args) {
        test();
    }
}

/*
内置注解：
    @Override：重写的注解
    @Deprecated：不建议使用的注解
    @SuppressWarnings：抑制编译时的警告信息
 */


/**
 * @author bingyi
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    // 注解的参数：参数类型 + 参数名 ()，并不是一个方法
    String name();
    int age() default 0;
    int id() default -1; // 如果默认值为 -1，代表不存在

    String[] schools() default {"a", "b"};
}