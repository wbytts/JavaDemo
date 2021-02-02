package com.by.gui.javafx.s021_BorderPane布局类;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        AnchorPane a1 = new AnchorPane();
        a1.setPrefWidth(100);
        a1.setPrefHeight(100);
        a1.setStyle("-fx-background-color: #EE6AA7");

        AnchorPane a2 = new AnchorPane();
        a2.setPrefWidth(100);
        a2.setPrefHeight(100);
        a2.setStyle("-fx-background-color: #98FB98");

        AnchorPane a3 = new AnchorPane();
        a3.setPrefWidth(100);
        a3.setPrefHeight(100);
        a3.setStyle("-fx-background-color: #A0522D");

        AnchorPane a4 = new AnchorPane();
        a4.setPrefWidth(100);
        a4.setPrefHeight(100);
        a4.setStyle("-fx-background-color: #1E90FF");

        AnchorPane a5 = new AnchorPane();
        a5.setPrefWidth(100);
        a5.setPrefHeight(100);
        a5.setStyle("-fx-background-color: #EEEE00");


        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: #B23AEE");
        // 能占用的会优先占用，不受子组件自身宽高限制
        borderPane.setTop(a1);
        borderPane.setBottom(a2);
        borderPane.setLeft(a3);
        borderPane.setRight(a4);
        borderPane.setCenter(a5);
        borderPane.setPadding(new Insets(10));

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
