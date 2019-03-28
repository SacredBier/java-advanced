package com.soft1841.io;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.time.LocalTime;

/**
 * @author SacredBier
 * 图片窗体程序
 * 2019/3/26
 */
public class ImgFrame extends JFrame {
    private JPanel topPanel;
    private JButton[] buttons;
    private JLabel imgLabel;
    private JLabel nameLabel;
    private JLabel timeLabel;
    private Icon icon;

    public ImgFrame() {
        init();
        setTitle("图片窗口");
        setSize(1000, 600);
        //窗口自动居中
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    //设置布局 放置组件
    public void init() {
        //顶部
        topPanel = new JPanel();
        buttons = new JButton[5];
        for (int i = 0; i < 5; i++) {
            buttons[i] = new JButton("按钮" + i);
            topPanel.add(buttons[i]);
        }
        add(topPanel, BorderLayout.NORTH);
        //中部
        imgLabel = new JLabel("相片");
        File srcFile = new File("D:/bg.jpg");
        InputStream inputStream;
        byte[] bytes = null;
        try {
            inputStream = new FileInputStream(srcFile);
            bytes = new byte[(int) srcFile.length()];
            inputStream.read(bytes);
        } catch (IOException e) {
            System.err.println("IO异常");
        }
        icon = new ImageIcon(bytes);
        imgLabel.setIcon(icon);
        add(imgLabel,BorderLayout.CENTER);
        //底部
        int size = (int) (srcFile.length()/1024);
        String srcFileName = srcFile.getAbsolutePath();
        nameLabel = new JLabel(srcFileName + " 大小：" + size + "K");
        add(nameLabel,BorderLayout.SOUTH);
        //左
        LocalTime time = LocalTime.now();
        timeLabel = new JLabel(time.toString());
        add(timeLabel,BorderLayout.EAST);
    }

    public static void main(String[] args) {
        new ImgFrame();
    }
}
