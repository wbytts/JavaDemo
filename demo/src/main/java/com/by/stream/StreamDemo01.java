package com.by.stream;

import org.junit.Test;

import java.util.Arrays;

public class StreamDemo01 {
    
    @Test
    public void test01() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] resultArr = Arrays.stream(arr).filter(i -> i % 2 != 0).toArray();
        System.out.println(Arrays.toString(resultArr));
    }
    
}
