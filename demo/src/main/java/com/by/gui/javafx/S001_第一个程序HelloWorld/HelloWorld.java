package com.by.gui.javafx.S001_第一个程序HelloWorld;

import javafx.application.Application;
import javafx.stage.Stage;

public class HelloWorld extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.show();
        primaryStage.setTitle("第一个JavaFX程序");
    }

}
