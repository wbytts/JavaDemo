package com.by.gui.javafx.S002_Application的启动方式;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main2 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
        // 另一个launch形式
        // Application.launch(Main2.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.show();
    }
}
