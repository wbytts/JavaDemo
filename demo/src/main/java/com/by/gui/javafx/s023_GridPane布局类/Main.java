package com.by.gui.javafx.s023_GridPane布局类;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
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

        GridPane grid = new GridPane();
        grid.setStyle("-fx-background-color: pink;");
        grid.add(b1, 0,0);
        // 另一种添加子组件的方式
        // GridPane.setConstraints(b1, 0, 0);
        // 也可以单独设置行和列的索引（通过 getChildren().add... 加入时）
        // GridPane.setRowIndex(b1, 0);
        // GridPane.setColumnIndex(b1, 0);
        grid.add(b2, 1,0);
        grid.add(b3, 2,0);
        grid.add(b4, 3,0);
        grid.add(b5, 0,1);
        grid.add(b6, 1,1);
        grid.add(b7, 2,1);
        grid.add(b8, 3,1);

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
