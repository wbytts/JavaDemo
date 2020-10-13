package com.by.gui.swing.s008_JLabel;

import javax.swing.*;
import java.awt.*;

/**
 * JLabel的属性设置
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

        JLabel label = new JLabel();
        label.setText("你好啊");
        label.setFont(new Font("微软雅黑", 0, 32));
        label.setForeground(Color.BLUE);
        label.setToolTipText("欢迎欢迎~~");

        // 向内容面板中添加控件
        contentPane.add(label);

    }
}
