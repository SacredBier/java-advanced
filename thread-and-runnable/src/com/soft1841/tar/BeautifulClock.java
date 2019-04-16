package com.soft1841.tar;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class BeautifulClock extends JFrame {

    Timer timer;
    JLabel jLabel;
    Font font = new Font("方正喵呜体", 0, 40);
    TimerTask task;

    public BeautifulClock() {
        init();
        setTitle("Timer定时器练习");
        setSize(300, 200);
        setLocation(1580, 880);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void init() {
        JPanel jPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                try {
                    Image bg = ImageIO.read(new File("D:/1.jpg"));
                    g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(jPanel);
        jLabel = new JLabel();
        jLabel.setFont(font);
        jPanel.add(jLabel);
        task = new TimerTask() {
            @Override
            public void run() {
                Date date = new Date();
                SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
                String timeString = df.format(date);
                jLabel.setText(timeString);
                if (timeString.equals("09:24:59")){
                    JOptionPane.showMessageDialog(null,"时间到~~");
                }
            }
        };
        timer = new Timer();
        timer.schedule(task, 10, 10);
    }

    public static void main(String[] args) {
        new BeautifulClock();
    }
}