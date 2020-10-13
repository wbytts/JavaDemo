package com.by.gui.awt;

import java.applet.Applet;
import java.awt.*;

public class ActionDemo extends Applet {
    Button button1 = new Button("按钮1");
    Button button2 = new Button("按钮2");

    public void init() {
        add(button1);
        add(button2);
    }

    public boolean action(Event evt, Object arg) {
        if(evt.target.equals(button1)) {
            getAppletContext().showStatus("这是按钮1");
        } else if(evt.target.equals(button2)) {
            getAppletContext().showStatus("这是按钮2");
        } else {
            return super.action(evt, arg);
        }
        return true;
    }

    public static void main(String[] args) {
        ActionDemo actionDemo = new ActionDemo();
        actionDemo.init();
        actionDemo.start();
    }
}
