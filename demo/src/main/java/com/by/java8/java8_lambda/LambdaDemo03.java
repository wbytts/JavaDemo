package com.by.java8.java8_lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 调用静态方法
 */
public class LambdaDemo03 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        // 调用 fun 方法过滤list里的元素，并把结果挨个打印出来
        // 静态方法可以用 XXX:fun_name 代替lambda或者接口传入
        list.stream().filter(M::fun).forEach(System.out::println);
        // 打印发现不会直接影响原 List
        System.out.println(list);
        // 收集处理后的结果
        List<Integer> resultList = list.stream().filter(M::fun).collect(Collectors.toList());
        System.out.println(resultList);
    }
}


class M {
    // 静态方法
    public static Boolean fun(Integer i) {
        return i < 5;
    }
}
