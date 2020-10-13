package com.by.gui.swing.s002_create_window;

import javax.swing.*;
import java.awt.*;

/**
 * @author bingyi
 */
public class S002CreateWindow {
    private static void createGUI() {
        // JFrame 指一个窗口，构造方法可以传递一个标题
        JFrame frame = new JFrame("Swing Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 获取窗口的内容面板
        Container contentPane = frame.getContentPane();
        // 设置内容面板的布局
        contentPane.setLayout(new FlowLayout());

        // 向内容面板中添加控件
        contentPane.add(new JLabel("Hello World"));
        contentPane.add(new JButton("测试"));

        JLabel l2 = new JLabel("sssss");
        contentPane.add(l2);

        // 设置窗口的大小
        frame.setSize(400, 300);
        // 设置窗口可见（默认窗口是不可见的）
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Oracle 官网Swing代码框架
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });
    }
}
