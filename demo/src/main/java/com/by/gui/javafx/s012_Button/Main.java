package com.by.gui.javafx.s012_Button;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button btn1 = new Button("一个按钮");
        // 设置按钮位置
        btn1.setLayoutX(100);
        btn1.setLayoutY(100);
        // 设置按钮大小
        btn1.setPrefWidth(400);
        btn1.setPrefHeight(200);
        // 设置按钮的文字字体
        btn1.setFont(Font.font("sans-serif", 40));
        // 设置背景
        BackgroundFill bgf = new BackgroundFill(Paint.valueOf("#8FBC8F"),
                                                new CornerRadii(20),
                                                new Insets(10));
        Background bg = new Background(bgf);
        btn1.setBackground(bg);

        Group group = new Group();
        group.getChildren().add(btn1);

        // 将 Group 添加到 Scene 上
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
