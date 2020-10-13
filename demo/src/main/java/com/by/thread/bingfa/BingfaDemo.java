package com.by.thread.bingfa;

// 多个线程同时操作一个对象
// 买火车票例子
/*
发现问题：多个线程操作同一个资源的情况下，数据混乱了
 */
public class BingfaDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        new Thread(t1, "小明").start();
        new Thread(t1, "小红").start();
        new Thread(t1, "小兰").start();
    }
}

class MyThread implements Runnable {
    // 票数
    int ticketNums = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }

            // 模拟延时
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "拿到了第" + (ticketNums--) + "票");
        }
    }
}
