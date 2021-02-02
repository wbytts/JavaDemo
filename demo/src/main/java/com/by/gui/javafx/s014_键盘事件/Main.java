package com.by.gui.javafx.s014_键盘事件;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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

        btn1.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("OnKeyPressed \t--> " + event.getCode().getName());
            }
        });
        btn1.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("OnKeyReleased \t--> " + event.getCode().getName());
                btn1.setText(event.getCode().getName());
            }
        });
        btn1.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("OnKeyTyped \t\t--> " + event.getCode().getName());
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
