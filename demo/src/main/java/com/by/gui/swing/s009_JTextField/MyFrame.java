package com.by.gui.swing.s009_JTextField;

import javax.swing.*;
import java.awt.*;

/**
 * JTextField
 *
 * @author bingyi
 */
public class MyFrame extends JFrame {

    JTextField textField = new JTextField(16);
    JButton button = new JButton("确定");

    public MyFrame(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 获取窗口的内容面板
        Container contentPane = getContentPane();
        // 设置内容面板的布局
        contentPane.setLayout(new FlowLayout());

        // 向内容面板中添加控件
        contentPane.add(new JLabel("姓名"));
        contentPane.add(textField);
        contentPane.add(button);

        button.addActionListener(e -> buttonClick());
    }

    private void buttonClick() {
        String str = textField.getText();
        // 弹出一个消息框
        JOptionPane.showMessageDialog(this, "输入了: " + str);
    }
}
