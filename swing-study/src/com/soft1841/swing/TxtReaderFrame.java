package com.soft1841.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * txt文件阅读器窗体
 */
public class TxtReaderFrame extends JFrame implements ActionListener {

    private JTextField inputField;
    private JButton confirmButton;
    private JPanel topPanel;
    private JTextArea contentArea;

    public TxtReaderFrame(){
        init();
        setTitle("文本阅读器");
        setSize(new Dimension(640,480));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init(){
        Font font = new Font("方正喵呜体",Font.PLAIN,26);
        inputField = new JTextField();
        inputField.setFont(font);
        inputField.setSize(new Dimension(300,40));
        confirmButton = new JButton("确认");
        confirmButton.setPreferredSize(new Dimension(100,40));
        topPanel = new JPanel();
        topPanel.setSize(new Dimension(500,50));
        topPanel.add(inputField);
        topPanel.add(confirmButton);
        //给按钮注册监听
        confirmButton.addActionListener(this);
        add(topPanel,BorderLayout.NORTH);
        contentArea = new JTextArea();
        contentArea.setFont(font);
        add(contentArea,BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new TxtReaderFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String filePath = inputField.getText().trim();
        File file = new File(filePath);
        try {
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            inputStream.read(bytes);
            String resultStr = new String(bytes);
            contentArea.append(resultStr + "\r\n");
        } catch (IOException e1) {
            System.err.println("IO异常");
        }
    }

}
