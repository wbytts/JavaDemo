package com.by.gui.swing.s003_my_jframe;

import javax.swing.*;
import java.awt.*;

/**
 * @author bingyi
 */
public class MyFrame extends JFrame {
    public MyFrame(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 获取窗口的内容面板
        Container contentPane = getContentPane();
        // 设置内容面板的布局
        contentPane.setLayout(new FlowLayout());

        // 向内容面板中添加控件
        contentPane.add(new JLabel("Hello World"));
        contentPane.add(new JButton("测试"));

        JLabel l2 = new JLabel("sssss");
        contentPane.add(l2);
    }
}
