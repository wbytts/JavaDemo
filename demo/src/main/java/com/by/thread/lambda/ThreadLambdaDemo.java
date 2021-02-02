package com.by.thread.lambda;

public class ThreadLambdaDemo {
    public static void main(String[] args) {
        new Thread(()-> System.out.println("Hello")).start();
    }
}
