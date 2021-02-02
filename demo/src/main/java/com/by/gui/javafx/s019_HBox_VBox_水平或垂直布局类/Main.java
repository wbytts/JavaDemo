package com.by.gui.javafx.s019_HBox_VBox_水平或垂直布局类;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button btn1 = new Button("按钮1");
        Button btn2 = new Button("按钮2");
        Button btn3 = new Button("按钮3");
        Button btn4 = new Button("按钮4");
        Button btn5 = new Button("按钮5");
        Button btn6 = new Button("按钮6");

        // Anchor 锚
        AnchorPane ap = new AnchorPane();
        ap.setStyle("-fx-background-color: pink;");


        HBox hbox = new HBox();
        hbox.setStyle("-fx-background-color: green;");
        hbox.setPrefWidth(400);
        hbox.setPrefHeight(400);
        hbox.getChildren().addAll(btn1, btn2, btn3);

        VBox vbox = new VBox();
        vbox.setStyle("-fx-background-color: blue;");
        vbox.setPrefWidth(400);
        vbox.setPrefHeight(400);
        vbox.getChildren().addAll(btn4, btn5, btn6);
        vbox.setLayoutY(400);

        // 内边距
        hbox.setPadding(new Insets(50, 20, 20, 20));
        // 子控件 外边距，这个是静态方法
        HBox.setMargin(btn1, new Insets(20));
        // 对齐方式，这个会影响设置的内边距的效果
        hbox.setAlignment(Pos.CENTER);

        ap.getChildren().addAll(hbox, vbox);

        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
