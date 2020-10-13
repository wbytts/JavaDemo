package com.by.gui.javafx.S002_Application的启动方式;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main3 {

    public static void main(String[] args) {
        Application.launch(Launch.class, args);
    }

}


// 两个类分开写
class Launch extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Main3");
        primaryStage.show();
    }
}