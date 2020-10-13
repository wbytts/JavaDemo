package com.by.gui.swing.s012_FlowLayout;


import javax.swing.*;

/**
 * JComboBox
 *
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
        // Oracle 官网 Swing 测试框架
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });
    }
}
