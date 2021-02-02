package com.by.gui.javafx.s018_AnchorPane布局类;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Anchor 锚
        AnchorPane ap = new AnchorPane();

        Button b1 = new Button("Button1");
        Button b2 = new Button("Button2");

        // 上下左右都是 10，按钮会被拉大
        // 这几个是静态方法，最好使用 AnchorPane 进行调用
        AnchorPane.setTopAnchor(b1, 10.0);
        AnchorPane.setLeftAnchor(b1, 10.0);
        AnchorPane.setRightAnchor(b1, 10.0);
        AnchorPane.setBottomAnchor(b1, 10.0);


        b2.setLayoutX(100);
        b2.setLayoutY(100);


        ap.getChildren().addAll(b1, b2);
        ap.setStyle("-fx-background-color: pink;");
        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
