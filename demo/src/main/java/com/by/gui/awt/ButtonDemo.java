package com.by.gui.awt;

import java.awt.*;

public class ButtonDemo extends Frame{
    static Frame frm = new Frame("Button class你好啊");
    static Button btn = new Button("登录");
    public static void main(String[] args) {
        // 不使用页面设置
        frm.setLayout(null);
        // 设置按钮的大小与位置
        btn.setBounds(45,65,100,40);
        frm.add(btn);
        frm.setVisible(true);
    }
}
