package com.by.gui.swing.s011_JComboBox;

import javax.swing.*;
import java.awt.*;

/**
 * JComboBox
 *
 * @author bingyi
 */
public class MyFrame extends JFrame {

    JComboBox<String> colorList = new JComboBox<>();
    JLabel sampleText = new JLabel("文本样例 This is a simple");

    public MyFrame(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 获取窗口的内容面板
        Container contentPane = getContentPane();
        // 设置内容面板的布局
        contentPane.setLayout(new FlowLayout());

        // 向内容面板中添加控件
        contentPane.add(colorList);
        contentPane.add(sampleText);

        colorList.addItem("红色");
        colorList.addItem("绿色");
        colorList.addItem("蓝色");

        // 使用了 lambda
        colorList.addActionListener(e -> selectColor());
    }

    private void selectColor() {
        int index = colorList.getSelectedIndex();
        if(index == 0) {
            sampleText.setForeground(Color.RED);
        } else if (index==1) {
            sampleText.setForeground(Color.GREEN);
        } else {
            sampleText.setForeground(Color.BLUE);
        }
    }

}

