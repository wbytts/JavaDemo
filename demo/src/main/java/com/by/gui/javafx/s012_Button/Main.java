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
        // 设置按钮位置
        btn1.setLayoutX(100);
        btn1.setLayoutY(100);
        // 设置按钮大小
        btn1.setPrefWidth(400);
        btn1.setPrefHeight(200);
        // 设置按钮的文字字体
        btn1.setFont(Font.font("sans-serif", 40));
        // 设置背景
        BackgroundFill bgf = new BackgroundFill(Paint.valueOf("#8FBC8F"),          // 背景  #8FBC8F00，最后的00代表透明度
                new CornerRadii(20),        // 圆角
                new Insets(10, 20, 30, 40)); // 按钮实体距离边框外围的距离
        Background bg = new Background(bgf);
        btn1.setBackground(bg);
        // 改变文字颜色
        btn1.setTextFill(Paint.valueOf("red"));
        BorderStroke borderStroke = new BorderStroke(Paint.valueOf("#8a2be2"),  // 边框颜色
                BorderStrokeStyle.SOLID,    // 边框样式
                new CornerRadii(20), // 边框圆角
                new BorderWidths(10));      // 边框宽度
        Border border = new Border(borderStroke);
        btn1.setBorder(border);

        Button btn2 = new Button("另一个按钮");
        btn2.setLayoutX(100);
        btn2.setLayoutY(400);
        btn2.setPrefWidth(400);
        btn2.setPrefHeight(200);

        // CSS 风格设置控件样式
        // 属性参考文档：https://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html
        btn2.setStyle(  "-fx-background-color: skyblue;" +
                        "-fx-background-radius: 30;" +
                        "-fx-font-size: 24px;" +
                        "-fx-text-fill: green;");


        // 设置按钮点击事件
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button btn = (Button) event.getSource();
                System.out.println("btn1被点击了[" + event + "]");
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
