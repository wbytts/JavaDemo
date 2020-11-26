package com.by.gui.javafx.S006_Stage模态;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author wangby
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage s1 = new Stage();
        s1.setTitle("s1");

        Stage s2 = new Stage();
        s2.setTitle("s2");
        s2.initOwner(s1);
        s2.initModality(Modality.WINDOW_MODAL); // 这个属性需要有 Owner设置才可以起作用


        Stage s3 = new Stage();
        s3.setTitle("s3");
        s3.initModality(Modality.APPLICATION_MODAL);


        s1.show();
        s2.show();
        s3.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
