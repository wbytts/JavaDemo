package com.by.gui.swing.s005_niming_inner_class;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 监听按钮点击事件，显示时间
 * @author bingyi
 */
public class MyFrame extends JFrame {

    JLabel timeLabel = new JLabel("00:00:00");
    JButton button = new JButton("显示时间");

    public MyFrame(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 获取窗口的内容面板
        Container contentPane = getContentPane();
        // 设置内容面板的布局
        contentPane.setLayout(new FlowLayout());

        // 向内容面板中添加控件
        contentPane.add(button);
        contentPane.add(timeLabel);

        // 把监听器注册给按钮（使用匿名内部类）
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按钮被点击了");
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String timeStr = sdf.format(new Date());
                timeLabel.setText(timeStr);
            }
        });
    }

}
