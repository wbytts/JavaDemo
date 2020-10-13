package com.by.thread.thread_status;

/**
 * 测试停止线程
 * 1. 建议线程正常停止 ---> 不建议死循环
 * 2. 建议使用标志位 --> 设置一个标志位
 * 3. 不要使用stop、destroy等过时或者JDK不建议使用的方法
 *
 * @author bingyi
 */
public class StopDemo implements Runnable {

    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("线程正在运行 ---> " + (i++));
        }
    }

    /**
     * 设置一个公开的方法停止线程
     */
    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        StopDemo stopDemo = new StopDemo();
        new Thread(stopDemo).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main --> " + i);
            if (i == 900) {
                // 调用stop方法，切换标志位，让线程停止
                stopDemo.stop();
                System.out.println("线程已停止");
            }
        }
    }
}


