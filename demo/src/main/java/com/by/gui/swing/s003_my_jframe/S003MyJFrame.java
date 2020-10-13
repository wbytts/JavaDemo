package com.by.gui.swing.s003_my_jframe;

import javax.swing.*;

/**
 * @author bingyi
 */
public class S003MyJFrame {
    private static void createGUI() {
        // JFrame 指一个窗口，构造方法可以传递一个标题
        JFrame frame = new MyFrame("Swing Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
