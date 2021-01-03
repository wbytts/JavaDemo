package com.by.gui.javafx.s011_Group;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button btn1 = new Button("b1");
        Button btn2 = new Button("b2");
        Button btn3 = new Button("b3");

        // 设置按钮位置
        btn1.setLayoutX(0);
        btn1.setLayoutY(10);
        // 设置按钮大小
        btn1.setPrefWidth(50);
        btn1.setPrefHeight(50);

        btn2.setLayoutX(150);
        btn2.setLayoutY(10);

        btn3.setLayoutX(300);
        btn3.setLayoutY(10);

        Group group = new Group();
        // 把 Button 添加到 Group 上面
        // 一个一个添加组件
        //group.getChildren().add(btn1);
        //group.getChildren().add(btn2);
        //group.getChildren().add(btn3);
        // 也可以一次性添加多个
        group.getChildren().addAll(btn1, btn2, btn3);
        //group.setAutoSizeChildren(false);  // 默认为 true
        // 会发现目前三个按钮重叠了，说明 Group 本身是没有什么布局的

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // 清除子组件
                //group.getChildren().clear();
                // 移除一个子组件，传入索引
                group.getChildren().remove(2);
            }
        });

        // 给 Group 设置一些属性，有的会影响到子组件
        //group.setOpacity(0.5);

        // 可以知道某一个点的位置上是否有一个组件（Node）
        // 注：只能检测到组件的左上角的位置（即使指定的点在组件内部也不行）
        boolean contains = group.contains(0, 10);
        System.out.println(contains);

        Object[] objects = group.getChildren().toArray();
        System.out.println(objects.length);
        for (Object object : objects) {
            Button btn = (Button) object;
            btn.setPrefWidth(100);
            btn.setPrefHeight(100);
        }

        // Group 监听 自己的子组件的变化
        group.getChildren().addListener(new ListChangeListener<Node>() {
            @Override
            public void onChanged(Change<? extends Node> c) {
                System.out.println("当前Group元素个数" + c.getList().size());
            }
        });

        // 给 btn1 添加按钮点击事件
        // 点击按钮时，给group增加一个 Button
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button btn = new Button("NEW");
                btn.setPrefWidth(100);
                btn.setPrefHeight(100);
                btn.setLayoutX(300);
                btn.setLayoutY(300);
                group.getChildren().add(btn);
            }
        });

        // 将 Group 添加到 Scene 上
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
