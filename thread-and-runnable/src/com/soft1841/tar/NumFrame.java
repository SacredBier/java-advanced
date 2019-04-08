package com.soft1841.tar;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class NumFrame extends JFrame {
    private JLabel numLabel,timeLabel;
    private JPanel colorPanel;

    public NumFrame() {
        init();
        setTitle("随机时间");
        setSize(1980, 1020);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init() {
        numLabel = new JLabel("随机数");
        Font font = new Font("方正喵呜体", Font.BOLD, 60);
        numLabel.setFont(font);
        timeLabel = new JLabel("时间");
        RandomFont randomFont = new RandomFont();
        timeLabel.setFont(randomFont.setFont(timeLabel));
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 300, 300);
        setLayout(flowLayout);
        colorPanel = new JPanel();
        colorPanel.add(numLabel);
        add(timeLabel);
        add(colorPanel);
        NumThread numThread = new NumThread();
        numThread.setRandomNum(numLabel);
        TimeThread timeThread = new TimeThread();
        timeThread.setTimeLabel(timeLabel);
        RandomColor randomColor = new RandomColor();
        randomColor.setColor(colorPanel);
        numThread.start();
        randomColor.start();
        timeThread.start();
        randomFont.start();
    }

    public static void main(String[] args) {
        new NumFrame();
    }
}

class NumThread extends Thread {
    JLabel jLabel;

    public void setRandomNum(JLabel jLabel) {
        this.jLabel = jLabel;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            int num = random.nextInt(100);
            jLabel.setText(String.valueOf(num));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class RandomColor extends Thread {
    JPanel jPanel;
    public void setColor(JPanel jPanel) {
        this.jPanel = jPanel;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true){
            Color color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
            jPanel.setBackground(color);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TimeThread extends  Thread {
    private JLabel timeLabel;
    public  void setTimeLabel(JLabel timeLabel){
        this.timeLabel = timeLabel;
    }

    @Override
    public void run() {
        while (true){
            Date date = new Date();
            SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss");
            timeLabel.setText((sf.format(date)));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class RandomFont extends Thread {
    JLabel jLabel;

    public Font setFont(JLabel jLabel){
        this.jLabel = jLabel;
        return jLabel.getFont();
    }

    @Override
    public void run() {
        String[] fonts = {"方正粗谭黑简体","方正黑体_GBK","方正隶变_GBK","方正流行体繁体","方正喵呜体"};
        while (true){
            Random random = new Random();
            Font font = new Font(fonts[random.nextInt(5)],Font.PLAIN,60);
            jLabel.setFont(font);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}