package com.by.gui.javafx.s022_FlowPane布局类;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button b1 = new Button("Button1");
        Button b2 = new Button("Button2");
        Button b3 = new Button("Button3");
        Button b4 = new Button("Button4");
        Button b5 = new Button("Button5");
        Button b6 = new Button("Button6");
        Button b7 = new Button("Button7");
        Button b8 = new Button("Button8");

        FlowPane flow = new FlowPane();
        flow.setStyle("-fx-background-color: pink;");
        flow.getChildren().addAll(b1, b2, b3, b4, b5, b6, b7, b8);

        flow.setAlignment(Pos.CENTER); // 设置对齐方式
        flow.setHgap(10); // 设置水平间距
        flow.setVgap(10); // 设置垂直间距

        // 设置排列方向：
        // 水平：Orientation.HORIZONTAL （默认）
        // 垂直：Orientation.VERTICAL
        flow.setOrientation(Orientation.VERTICAL);

        // 特点：当宽度不够的时候，会重新排列（不会缩放子组件）
        // 会参照前一个组件排列

        Scene scene = new Scene(flow);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
