package com.by.thread.threadclass;

// 创建线程方式1：继承Thread类，重写run方法，调用start开启线程

// 注意：线程开启不一定执行，由系统调度执行

public class ThreadDemo01 {
    public static void main(String[] args) {
        // main 方法 主线程
        MyThread mt1 = new MyThread();
        // mt1.run(); // 如果使用run，只是简单的方法调用
        mt1.start(); // 使用start方法启动线程，而不是run
        for (int i = 0; i < 10; i++) {
            System.out.println("main: " + i);
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        // run 方法线程体
        for (int i = 0; i < 10; i++) {
            System.out.println("MyThread: " + i);
        }
    }
}
