package com.by.gui.javafx.S005_Stage模式;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        /*
            DECORATED   普通背景有装饰
                Defines a normal Stage style with a solid white background and platform decorations.

            TRANSPARENT   透明背景无装饰
                Defines a Stage style with a transparent background and no decorations.

            UNDECORATED   纯白背景无装饰
                Defines a Stage style with a solid white background and no decorations.

            UNIFIED   用平台装饰定义舞台风格，消除客户区和装饰之间的边界
                Defines a Stage style with platform decorations and eliminates the border between client area and decorations.

            UTILITY   定义一个舞台样式，它具有纯白色背景和用于工具窗口的最小平台装饰
                Defines a Stage style with a solid white background and minimal platform decorations used for a utility window.
         */

        Stage s1 = new Stage();
        s1.setTitle("s1");
        s1.initStyle(StageStyle.DECORATED);  // 初始化 Stage 类型
        s1.show();

        Stage s2 = new Stage();
        s2.setTitle("s2");
        s2.initStyle(StageStyle.TRANSPARENT);
        s2.show();

        Stage s3 = new Stage();
        s3.setTitle("s3");
        s3.initStyle(StageStyle.UNDECORATED);
        s3.show();

        Stage s4 = new Stage();
        s4.setTitle("s4");
        s4.initStyle(StageStyle.UNIFIED);
        s4.show();

        Stage s5 = new Stage();
        s5.setTitle("s5");
        s5.initStyle(StageStyle.UTILITY);
        s5.show();

        Thread.sleep(10000);
        Platform.exit(); // 退出所有窗口
    }

    public static void main(String[] args) {
        launch(args);
    }
}
