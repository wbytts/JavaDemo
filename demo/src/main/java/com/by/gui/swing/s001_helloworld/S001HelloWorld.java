package com.by.gui.swing.s001_helloworld;

import javax.swing.*;
import java.awt.*;

/**
 * @author bingyi
 */
public class S001HelloWorld {
    private static void createGUI() {
        JFrame frame = new JFrame("Swing Demo");

        // 设置frame关闭时的默认行为，在关闭时退出
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
            FlowLayout：自左到右排列，显示不下，换行排列
         */

        // 获取frame的内容面板，是一个容器类型
        Container contentPane = frame.getContentPane();
        // 设置面板的布局为 FlowLayout
        contentPane.setLayout(new FlowLayout());
        // 向面板中添加其他组件
        contentPane.add(new JLabel("Hello World"));
        contentPane.add(new JButton("测试"));

        // 设置面板的大小
        frame.setSize(400, 300);
        // 设置面板可见
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });
    }
}
