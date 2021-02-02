package com.by.gui.javafx.s018_AnchorPane布局类;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main4 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane ap = new AnchorPane();
        AnchorPane ap2 = new AnchorPane();


        // 没有设置宽高的时候，ap2默认是缩在一起的，宽高都是0
        ap.setStyle("-fx-background-color: pink;" +
                "-fx-border-width: 5px;" +
                "-fx-border-color: red;");
        ap2.setStyle("-fx-background-color: green;" +
                "-fx-border-width: 5px;" +
                "-fx-border-color: blue;");

        ap.getChildren().add(ap2);
        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
