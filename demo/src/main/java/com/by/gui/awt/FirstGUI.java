package com.by.gui.awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FirstGUI {
    public static void main(String[] args) {
        // Frame
        Frame frame = new Frame("第一个Frame界面！");

        // 设置窗口可见性
        frame.setVisible(true);

        // 设置窗口大小
        frame.setSize(400, 400);

        // 设置背景颜色
        frame.setBackground(new Color(255, 0, 0));

        // 设置弹窗初始位置
        frame.setLocation(200, 200);

        // 设置窗口大小固定
        frame.setResizable(false);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
