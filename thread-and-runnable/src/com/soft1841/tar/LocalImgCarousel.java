package com.soft1841.tar;

import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LocalImgCarousel extends JFrame implements ActionListener {

    private JButton chooseBtn, newThreadBtn;
    private JPanel imgPanel, btnPanel;
    private JLabel timeLabel;

    public LocalImgCarousel() {
        init();
        setTitle("轮播");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init() {
        chooseBtn = new JButton("选择图片");
        newThreadBtn = new JButton("播放音乐");
        btnPanel = new JPanel(new FlowLayout());
        btnPanel.add(chooseBtn);
        btnPanel.add(newThreadBtn);
        add(btnPanel, BorderLayout.NORTH);
        chooseBtn.addActionListener(this);
        newThreadBtn.addActionListener(this);
        imgPanel = new JPanel();
        add(imgPanel, BorderLayout.CENTER);
        timeLabel = new JLabel();
        GetTime getTime = new GetTime();
        Font font = new Font("方正喵呜体", Font.BOLD, 60);
        timeLabel.setFont(font);
        getTime.setTimeLabel(timeLabel);
        new Thread(getTime).start();
        add(timeLabel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new LocalImgCarousel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseBtn) {
            JLabel imgLabel = new JLabel();
            imgPanel.add(imgLabel);
            ChooseImg chooseImg = new ChooseImg();
            chooseImg.setBgLabel(imgLabel);
            Thread thread = new Thread(chooseImg);
            thread.start();
        } else if (e.getSource() == newThreadBtn) {
            PlayMusic playMusic = new PlayMusic();
            Thread thread = new Thread(playMusic);
            thread.start();
        }
    }
}

class ChooseImg implements Runnable {
    private JLabel bgLabel;
    private JFileChooser fileChooser;

    public void setBgLabel(JLabel bgLabel) {
        this.bgLabel = bgLabel;
    }

    @Override
    public void run() {
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("C:\\Users\\SacredBier\\Pictures"));
        fileChooser.setMultiSelectionEnabled(true);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File[] files = fileChooser.getSelectedFiles();
            int i = 0;
            int len = files.length - 1;
            while (true) {
                try {
                    File file = new File(String.valueOf(files[i]));
                    InputStream inputStream = new FileInputStream(file);
                    byte[] bytes = new byte[(int) file.length()];
                    inputStream.read(bytes);
                    Icon icon = new ImageIcon(bytes);
                    bgLabel.setIcon(icon);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                    if (i == len) {
                        i = 0;
                    }
                } catch (IOException e) {
                    System.err.println("IO异常");
                }
            }
        }
    }
}

class PlayMusic implements Runnable {
    @Override
    public void run() {
        URL url;
        File file = new File("D:\\bg1.wav");
        try {
            url = file.toURL();
            AudioClip audioClip = Applet.newAudioClip(url);
            audioClip.play();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

class GetTime implements Runnable {
    private JLabel timeLabel;

    public void setTimeLabel(JLabel timeLabel) {
        this.timeLabel = timeLabel;
    }

    @Override
    public void run() {
        while (true) {
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
