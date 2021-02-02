package com.by.gui.javafx.s018_AnchorPane布局类;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main5 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane ap = new AnchorPane();
        AnchorPane ap2 = new AnchorPane();

        AnchorPane.setTopAnchor(ap2, 50.0);
        AnchorPane.setRightAnchor(ap2, 50.0);
        AnchorPane.setBottomAnchor(ap2, 50.0);
        AnchorPane.setLeftAnchor(ap2, 50.0);


        ap.setStyle("-fx-background-color: pink;" +
                "-fx-border-width: 5px;" +
                "-fx-border-color: red;");
        ap2.setStyle("-fx-background-color: green;" +
                "-fx-border-width: 5px;" +
                "-fx-border-color: blue;");
        
        ap.getChildren().add(ap2);
        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
