package com.by.gui.javafx.s007_Paltform类的使用;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // 空闲的时候运行
        /*
            发现并没有新开一个线程
            这个其实是一个队列，在线程空闲的时候帮你更新UI界面
         */
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("platform-runnable: threadName=" + Thread.currentThread().getName());
                // 在这里可以对组件进行更新
                System.out.println("Platform Runnable 执行");
                int i = 1;
                while( i< 10) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("i="+i);
                    i = i + 1;
                }
            }
        });
        System.out.println("outer threadName=" + Thread.currentThread().getName());
        System.out.println("Platform Runnable 下面");

        /*
            Platform.setImplicitExit(..) 将所有窗口关闭后是不是不退出虚拟机
            如果设置为false，即使程序的所有窗口都关闭了，程序依旧不会停止，需要调用 primaryStage.exit()
            如果不设置，默认就是true，所有窗口关闭了也就退出了
         */
        // // // // // // // // // // // // // // // // // // // // // // //
        /*
            Platform.isSupport(..) 是不是支持某种特性
            检查电脑平台的一些特性
         */
    }
}
