package com.by.gui.javafx.s015_快捷键;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.*;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button btn1 = new Button("一个按钮");
        btn1.setLayoutX(100);
        btn1.setLayoutY(100);
        Button btn2 = new Button("另一个按钮");
        btn2.setLayoutX(100);
        btn2.setLayoutY(200);

        Group group = new Group();
        group.getChildren().add(btn1);
        group.getChildren().add(btn2);
        Scene scene = new Scene(group);

        // 第一种
        KeyCombination kc1 = new KeyCodeCombination(KeyCode.C, KeyCombination.ALT_DOWN, KeyCombination.CONTROL_DOWN);
        Mnemonic mnemonic1 = new Mnemonic(btn1, kc1);
        scene.addMnemonic(mnemonic1);

        // 第二种
        KeyCombination kc2 = new KeyCharacterCombination("O", KeyCombination.ALT_DOWN);
        Mnemonic mnemonic2 = new Mnemonic(btn1, kc2);
        scene.addMnemonic(mnemonic2);

        // 第三种
        KeyCombination kc3 = new KeyCodeCombination(KeyCode.K, KeyCombination.SHIFT_DOWN, KeyCombination.CONTROL_DOWN, KeyCombination.ALT_DOWN, KeyCombination.META_DOWN, KeyCombination.SHORTCUT_DOWN);
        Mnemonic mnemonic3 = new Mnemonic(btn1, kc3);
        scene.addMnemonic(mnemonic3);

        // 第四种
        KeyCombination kc4 = new KeyCodeCombination(KeyCode.Y, KeyCombination.SHORTCUT_DOWN);
        scene.getAccelerators().put(kc4, new Runnable() {
            @Override
            public void run() {
                System.out.println("run 方法");
                // 打印一下当前线程的名字  JavaFX Application Thread
                // 并没有新开一个线程
                System.out.println(Thread.currentThread().getName());
            }
        });

        /*
            SHORTCUT 是平台无关的
            在windows里处理为 Ctrl
            在Mac中处理成 Command
         */

        primaryStage.setScene(scene);
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
