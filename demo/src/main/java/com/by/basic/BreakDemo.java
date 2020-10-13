package com.by.basic;

public class BreakDemo {
    public static void main(String[] args) {
        xxx:
        for (int i = 0; i < 10; i++) {
            yyy:
            for (int j = 0; j < 10; j++) {
                if (i + j == 10) {
                    break yyy;
                } else {
                    System.out.println("i=" + i + ", j=" + j);
                }
            }
        }
        System.out.println("Hello World");
    }
}
