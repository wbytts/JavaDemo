package com.by.gui.swing.s008_JLabel;


import javax.swing.*;

/**
 * JLabel的基本使用
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
