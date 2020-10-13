package com.by.gui.swing.s001_helloworld;

import javax.swing.*;
import java.awt.*;

/**
 * @author bingyi
 */
public class S001HelloWorld {
    private static void createGUI() {
        JFrame frame = new JFrame("Swing Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
            FlowLayout：自左到右排列，显示不下，换行排列

         */

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(new JLabel("Hello World"));
        contentPane.add(new JButton("测试"));

        frame.setSize(400, 300);
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
