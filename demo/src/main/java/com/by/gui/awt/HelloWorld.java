package com.by.gui.awt;

import java.awt.*;

public class HelloWorld extends Frame {
    // 创建Frame对象
    static HelloWorld frm = new HelloWorld();
    // 创建Label
    static Label lab = new Label();

    public static void main(String[] args) {
        // 设置窗口位置
        frm.setLocation(250,250);
        // 设置窗口大小
        frm.setSize(400, 400);
        // 设置窗口背景颜色为粉红色
        frm.setBackground(Color.pink);
        // 标签内容
        lab.setText("Hello Java 你好啊");
        // 标签内文字居中
        lab.setAlignment(Label.CENTER);
        // 标签内文字颜色为蓝色
        lab.setForeground(Color.blue);
        // 设置标签字体样式
        Font fnt = new Font("Consolas", Font.ITALIC+Font.BOLD, 19);
        lab.setFont(fnt);
        // frm中加入lab
        frm.add(lab);
        frm.setVisible(true);

        HelloWorld mainFrame = new HelloWorld();
    }
}
