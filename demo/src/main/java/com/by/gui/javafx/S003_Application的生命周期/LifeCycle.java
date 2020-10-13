package com.by.gui.javafx.S003_Application的生命周期;

import javafx.application.Application;
import javafx.stage.Stage;

public class LifeCycle extends Application {

    public static void main(String[] args) {
        System.out.println("main() = " + Thread.currentThread().getName());
        launch(args); // 其实是启动了一个UI线程
    }

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("调用了init方法. "  + Thread.currentThread().getName());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("调用了start方法. "  + Thread.currentThread().getName());
        primaryStage.setTitle("生命周期");
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("调用了stop方法. "  + Thread.currentThread().getName());
    }
}
