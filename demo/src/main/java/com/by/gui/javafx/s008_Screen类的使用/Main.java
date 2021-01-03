package com.by.gui.javafx.s008_Screen类的使用;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        /*
            Screen 主要用于获取屏幕的一些信息
         */
        // 获得主屏幕
        Screen primaryScreen = Screen.getPrimary();

        // 获取整个屏幕的范围
        Rectangle2D bounds = primaryScreen.getBounds();
        System.out.println(bounds);

        // 获取可视区的范围
        Rectangle2D visualBounds = primaryScreen.getVisualBounds();
        System.out.println(visualBounds);

        // 获取屏幕 DPI
        double dpi = primaryScreen.getDpi();
        System.out.println("当前屏幕dpi=" + dpi);


        Platform.exit();
    }
}
