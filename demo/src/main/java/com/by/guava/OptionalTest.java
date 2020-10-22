package com.by.guava;

import com.google.common.base.Optional;

public class OptionalTest {
    public static void main(String args[]) {
        OptionalTest demo = new OptionalTest();

        Integer value1 = null;
        Integer value2 = new Integer(10);

        // Optional.fromNullable：允许参数为null.
        Optional<Integer> a = Optional.fromNullable(value1);
        // Optional.of：如果参数为null，则抛出NullPointerException
        Optional<Integer> b = Optional.of(value2);

        System.out.println(demo.sum(a, b));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b) {
        // Optional.isPresent：检查值是否存在
        System.out.println("First parameter is present: " + a.isPresent());
        System.out.println("Second parameter is present: " + b.isPresent());

        // Optional.or：如果存在则返回值，否则返回传递的默认值
        Integer value1 = a.or(new Integer(0));

        // Optional.get：获取值，此时有值存在
        Integer value2 = b.get();

        return value1 + value2;
    }
}