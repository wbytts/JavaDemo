package com.by.gui.swing.s005_niming_inner_class;

import javax.swing.*;

/**
 * 演示Swing中按钮点击事件的写法
 * @author bingyi
 */
public class Demo {
    private static void createGUI() {
        JFrame frame = new MyFrame("Swing Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });
    }


}
