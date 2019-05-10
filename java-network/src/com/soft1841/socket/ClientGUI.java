package com.soft1841.socket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class ClientGUI extends JFrame implements ActionListener {
    private JButton sendBtn;
    private JButton connectBtn;
    private JTextArea contentArea;
    private JTextField sendField;
    private Socket socket;

    public ClientGUI() {
        init();
        setTitle("客户端");
        setSize(840, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init() {
        Container c = getContentPane();
        this.setLayout(null);
        contentArea = new JTextArea();
        contentArea.setEditable(false);
        contentArea.setForeground(Color.BLUE);
        contentArea.setBackground(Color.WHITE);
        connectBtn = new JButton("连接服务器");
        connectBtn.setBounds(150, 150, 100, 40);
        connectBtn.addActionListener(this);
        sendField = new JTextField();
        sendField.setBounds(20, 50, 790, 100);
        sendField.setVisible(false);
        sendBtn = new JButton("发送");
        sendBtn.setBounds(660, 250, 100, 40);
        sendBtn.addActionListener(this);
        sendBtn.setVisible(false);
        c.add(connectBtn);
        c.add(sendField);
        c.add(sendBtn);
    }

    public static void main(String[] args) {
        new ClientGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == connectBtn) {
            try {
                socket = new Socket("127.0.0.1", 1912);
                JOptionPane.showMessageDialog(null, "服务器连接成功", "连接成功", JOptionPane.INFORMATION_MESSAGE);
                sendField.setVisible(true);
                sendBtn.setVisible(true);
                connectBtn.setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == sendBtn) {
            OutputStream out = null;
            try {
                out = socket.getOutputStream();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            String message = sendField.getText();
            try {
                out.write(message.getBytes());
           } catch (IOException ex) {
                ex.printStackTrace();
            }
            contentArea.append(message + "\n");
            sendField.setText("");
        }
    }
}
