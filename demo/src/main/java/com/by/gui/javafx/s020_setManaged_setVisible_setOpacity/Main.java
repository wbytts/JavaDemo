package com.by.gui.javafx.s020_setManaged_setVisible_setOpacity;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.python.antlr.ast.Print;

public class Main extends Application {

    static boolean isManaged = false;
    static boolean isVisible = false;
    static double opacityValue = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button b1 = new Button("按钮1");
        Button b2 = new Button("按钮2");
        Button b3 = new Button("按钮3");
        Button b4 = new Button("按钮4");
        Button b5 = new Button("b3.setManaged(false)");
        Button b6 = new Button("b3.setVisible(false)");
        Button b7 = new Button("b3.setOpacity(0)");

        // 消失了，不占位置，但是还在布局容器里
        b3.setManaged(false);
        // 不可见了，但是还占着位置
        b3.setVisible(false);
        // 透明了
        b3.setOpacity(0);

        // Anchor 锚
        AnchorPane ap = new AnchorPane();
        ap.setStyle("-fx-background-color: #ffffff");

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(20));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(b1, b2, b3, b4);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(b5, b6, b7);

        AnchorPane.setTopAnchor(vBox, 100.0);
        AnchorPane.setLeftAnchor(vBox, 20.0);
        ap.getChildren().addAll(hBox, vBox);
        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        b5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                b3.setManaged(isManaged);
                new Paint(hBox);
                isManaged = !isManaged;
                b5.setText("b3.setManaged(" + isManaged + ")");
            }
        });

        b6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                b3.setVisible(isVisible);
                new Paint(hBox);
                isVisible = !isVisible;
                b6.setText("b3.setVisible(" + isVisible + ")");
            }
        });

        b7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                b3.setOpacity(opacityValue);
                new Paint(hBox);
                opacityValue = opacityValue == 0 ? 1 : 0;
                b7.setText("b3.setOpacity(" + opacityValue + ")");
            }
        });

    }
}

class Paint {
    Paint(HBox hBox) {
        System.out.println("当前HBox里子组件数量=" + hBox.getChildren().size());
    }
}
