package com.by.gui.javafx.s016_输入框;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 输入框

        Group group = new Group();
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);

        TextField text = new TextField();
        text.setText("");
        text.setPrefWidth(600);
        text.setPrefHeight(80);
        text.setLayoutX(100);
        text.setLayoutY(100);
        text.setFont(Font.font(32));
        // 鼠标放上去时的提示
        Tooltip tip = new Tooltip("这是提示内容");
        tip.setFont(Font.font(16));
        text.setTooltip(tip);
        text.setPromptText("请输入一段内容（不超过7个字）");
        text.setFocusTraversable(false);   // 使其失去焦点

        // 监听文本变化
        text.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(newValue);
                if(newValue.length() > 7) {
                    text.setText(oldValue);
                }
            }
        });

        // 监听被选中的文字
        text.selectedTextProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("选中了: " + newValue);
            }
        });
        group.getChildren().add(text);

        // 密码框
        PasswordField ptext = new PasswordField();
        ptext.setText("");
        ptext.setPrefWidth(600);
        ptext.setPrefHeight(80);
        ptext.setLayoutX(100);
        ptext.setLayoutY(200);
        ptext.setFont(Font.font(32));
        group.getChildren().add(ptext);


        primaryStage.show();
    }
}
