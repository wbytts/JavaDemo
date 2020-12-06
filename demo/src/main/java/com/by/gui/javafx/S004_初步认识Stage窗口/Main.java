package com.by.gui.javafx.S004_初步认识Stage窗口;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        /*
            javafx.stage.Stage：是一个窗口
                Stage继承于 javafx.stage.Window（继承于 Object）
                在不同的平台上具有不同的效果显示
         */

        primaryStage.setTitle("这是标题");
        // primaryStage.getIcons().add(new Image("/icon/icon.png")); // 设置图标
        // primaryStage.setIconified(true); // 设置窗口最小化
        // primaryStage.setMaximized(true); // 设置窗口最大化
        primaryStage.setWidth(500); // 设置宽度
        primaryStage.setHeight(500); // 设置高度
        primaryStage.setMaxHeight(700); // 设置最大高度
        primaryStage.setMinHeight(300); // 设置最小高度
        primaryStage.setMaxWidth(700); // 设置最大宽度
        primaryStage.setMinWidth(300); // 设置最小宽度
        // primaryStage.setResizable(false); // 设置是否可以改变窗口大小

        // 监听高度的变化
        primaryStage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("newHeight = " + newValue);
            }
        });

        // 监听宽度的变化
        primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("new Width = " + newValue);
            }
        });

        // 监听窗口 x坐标 的变动
        primaryStage.xProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("x = " + newValue);
            }
        });
        // 监听窗口 y坐标 的变动
        primaryStage.yProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("y = " + newValue);
            }
        });

        // 设置全屏（与最大化不同）
        //primaryStage.setFullScreen(true);
        //primaryStage.setScene(new Scene(new Group()));

        primaryStage.show(); // 让窗口进行显示
        // primaryStage.close(); // 关闭窗口

        // 如果没有设定宽高，则需要在 show 方法之后再去获取宽高


        // 也可以不用参数提供的这个窗口，自己创建一个
        Stage stage = new Stage();
        stage.show();
        Thread.sleep(3000);
        stage.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
