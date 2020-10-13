package com.by.gui.awt;

import java.awt.*;

public class TestMyFrame {
    public static void main(String[] args) {
        MyFrame f1 = new MyFrame(200, 200, 400, 400);
        MyFrame f2 = new MyFrame(600, 200, 400, 400);
        MyFrame f3 = new MyFrame(1000, 200, 400, 400);
    }
}
class MyFrame extends Frame {
    static int id = 0;
    public MyFrame(int x, int y, int w, int h) {
        super("窗口 " + (++id));
        setVisible(true);
        setSize(w, h);
        setLocation(x, y);
        setResizable(false);

    }
}