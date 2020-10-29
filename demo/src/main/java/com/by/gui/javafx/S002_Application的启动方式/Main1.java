package com.by.gui.javafx.S002_Application的启动方式;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author wangby
 */
public class Main1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Main1");
        primaryStage.show();
    }
}
