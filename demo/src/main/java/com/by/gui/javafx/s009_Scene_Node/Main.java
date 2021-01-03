package com.by.gui.javafx.s009_Scene_Node;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // 创建 Scene， 注：Scene 上面必须要有一个 Node！
        Button button = new Button("一个按钮");
        button.setPrefWidth(200);
        button.setPrefHeight(200);
        Group group = new Group();
        group.getChildren().add(button);
        Scene scene = new Scene(group);

        // 关联 Stage 和 Scene
        primaryStage.setScene(scene);

        primaryStage.setTitle("JavaFX by bingyi");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
