package com.by.gui.javafx.s018_AnchorPane布局类;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main3 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Anchor 锚
        AnchorPane ap = new AnchorPane();

        Button b1 = new Button("Button1");
        Button b2 = new Button("Button2");
        Button b3 = new Button("Button3");
        Button b4 = new Button("Button4");

        b1.setLayoutX(100);
        b1.setLayoutY(100);

        Group g1 = new Group();
        Group g2 = new Group();

        AnchorPane.setTopAnchor(g1, 100.0);
        AnchorPane.setLeftAnchor(g1, 100.0);
        AnchorPane.setTopAnchor(g2, 200.0);
        AnchorPane.setLeftAnchor(g2, 200.0);

        g1.getChildren().addAll(b1, b2);
        g2.getChildren().addAll(b3, b4);
        ap.getChildren().addAll(g1, g2);

        ap.setStyle("-fx-background-color: pink;");
        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
