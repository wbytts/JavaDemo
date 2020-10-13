package com.by.thread.runnable_interface;

/*
创建线程方式2：实现Runnable接口，实现run方法
执行线程需要丢入Runnable接口的实现类，调用start方法

1. 一个类实现Runnable接口
2. 新建线程，传入实现了Runnable接口的对象
3. 启动线程
 */
public class TestRunnable01 implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello Runnable");
    }

    public static void main(String[] args) {
        TestRunnable01 r1 = new TestRunnable01();

//        Thread t1 = new Thread(r1);
//        t1.start();

        new Thread(r1).start();
    }
}
