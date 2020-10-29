package com.by.gui.swing.s012_FlowLayout;

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

        /*
            FlowLayout：流布局
                默认的，自左至右逐个排列
                当一行排满时，自动排列下一行

           setPreferredSize()：控制每个控件的显示高度和宽度
         */

        JLabel a1 = new JLabel("a1");
        JLabel a2 = new JLabel("a2");
        JLabel a3 = new JLabel("a3");
        JLabel a4 = new JLabel("a4");
        JLabel a5 = new JLabel("a5");

        contentPane.add(a1);
        contentPane.add(a2);
        contentPane.add(a3);
        contentPane.add(a4);
        contentPane.add(a5);
    }
}

