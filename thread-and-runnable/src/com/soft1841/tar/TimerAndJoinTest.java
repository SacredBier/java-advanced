package com.soft1841.tar;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class TimerAndJoinTest extends JFrame {
    JPanel ovalPanel;
    JTextArea jTextArea;

    public TimerAndJoinTest() {
        init();
        setTitle("TimerAndJoinTest");
        setSize(1980, 1020);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init() {
        ovalPanel = new JPanel();
        ovalPanel.setSize(new Dimension(990, 1020));
        CircleThread circleThread = new CircleThread();
        circleThread.setFrame(this);
        new Thread(circleThread).start();
        add(ovalPanel, BorderLayout.WEST);
        jTextArea = new JTextArea();
        jTextArea.setLineWrap(true);
        jTextArea.setFont(new Font("方正喵呜体", 0, 60));
        jTextArea.setSize(new Dimension(520, 1020));
        String string = ("把这些字一个一个输出");
        char[] chars = string.toCharArray();
        final String[] s = {new String()};
        TimerTask writeWord = new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < chars.length; i++) {
                    s[0] += String.valueOf(chars[i]);
                    jTextArea.setText(s[0]);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(writeWord, 2000, 10);
        add(jTextArea, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        new TimerAndJoinTest();
    }
}

class CircleThread implements Runnable {
    int x = 800;
    int y = 800;
    private JFrame frame;

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void run() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                for (int i = 1; i <= 18; i++) {
                    try {
                        Thread.sleep(900);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Graphics graphics = frame.getGraphics();
                    graphics.setColor(new Color(new Random().nextInt(256), new Random().nextInt(256), new Random().nextInt(256)));
                    graphics.drawOval(x / 2 - (i + 1) * 10, y / 2 - (i + 1) * 10, 10 + 20 * i, 10 + 20 * i);
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, 5, 1000);

    }
}
