package com.by.gui.javafx.s010_HostServices;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 打开一个网页
        HostServices host = getHostServices();
        host.showDocument("http://www.baidu.com");
    }
}
