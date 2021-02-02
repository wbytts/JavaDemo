package com.by.gui.javafx.s013_双击事件;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
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
        btn1.setLayoutX(100);
        btn1.setLayoutY(100);
        Button btn2 = new Button("另一个按钮");
        btn2.setLayoutX(100);
        btn2.setLayoutY(200);

        // 设置按钮点击事件
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button btn = (Button) event.getSource();
                // System.out.println("btn1被点击了[" + event + "]");
            }
        });

        // 点击事件的其他写法
        // btn1.addEventFilter();
        // btn1.addEventHandler();
        btn1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("鼠标按键=" + event.getButton().name());  // PRIMARY左键，SECONDARY右键，MIDDLE中键
                System.out.println("连续点击次数=" + event.getClickCount()); // 获取单击的次数，借此实现连击监听

                // 鼠标左键，连续点击两次
                if (event.getButton().name().equals(MouseButton.PRIMARY.name()) && event.getClickCount() == 2) {
                    System.out.println("鼠标左键连续点击两次");
                }
                System.out.println("------------------------------");
            }
        });


        Group group = new Group();
        group.getChildren().add(btn1);
        group.getChildren().add(btn2);

        // 将 Group 添加到 Scene 上
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
