package com.by.gui.swing.s010_JCheckBox;

import javax.swing.*;
import java.awt.*;

/**
 * JCheckBox
 *
 * @author bingyi
 */
public class MyFrame extends JFrame {

    JCheckBox cbx = new JCheckBox("啦啦啦");
    JTextField email = new JTextField(16);

    public MyFrame(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 获取窗口的内容面板
        Container contentPane = getContentPane();
        // 设置内容面板的布局
        contentPane.setLayout(new FlowLayout());

        // 向内容面板中添加控件
        contentPane.add(cbx);
        contentPane.add(email);

        cbx.addActionListener(e -> select());
        email.setEnabled(false);

    }

    private void select() {
        if (cbx.isSelected()) {
            System.out.println("选中~");
            email.setEnabled(true);
        } else {
            System.out.println("取消选中");
            email.setEnabled(false);
        }
    }
}

