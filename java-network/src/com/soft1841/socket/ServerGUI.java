package com.soft1841.socket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerGUI extends JFrame implements ActionListener {
    private JButton StartButton;
    private static JTextArea jTextArea;

    public static JTextArea getJTextArea() {
        return jTextArea;
    }

    public ServerGUI() {
        init();
        setTitle("服务端窗体");
        setLocationRelativeTo(null);
        setBounds(200, 100, 400, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init() {
        StartButton = new JButton("启动服务器");
        StartButton.addActionListener(this);
        jTextArea = new JTextArea();
        add(StartButton, BorderLayout.NORTH);
        add(jTextArea, BorderLayout.CENTER);

    }


    public static void main(String[] args) {
        new ServerGUI();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == StartButton) {
            ServerThread2 t2 = new ServerThread2();
            new Thread(t2).start();
        }
    }

    static class ServerThread1 implements Runnable {
        private Socket socket;

        public ServerThread1(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            jTextArea.setText(jTextArea.getText() + "\n客户端" + socket.getInetAddress() + "连接成功！" + "\n");
        }
    }

    static class ServerThread2 implements Runnable {
        private ServerSocket serverSocket;

        @Override
        public void run() {
            try {
                serverSocket = new ServerSocket(1912);
            } catch (IOException e) {
                e.printStackTrace();
            }
            jTextArea.setText(jTextArea.getText() + "\n服务器启动");
            Socket socket = null;
            while (true) {
                try {
                    socket = serverSocket.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ServerThread1 server = new ServerThread1(socket);
                new Thread(server).start();
                ReceiveThread3 t3 = new ReceiveThread3(socket);
                new Thread(t3).start();
            }

        }
    }
}


class ReceiveThread3 implements Runnable {
    private Socket socket;

    public ReceiveThread3(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in;
        while (true) {
            try {
                in = socket.getInputStream();
                byte[] b = new byte[1024];
                in.read(b);
                ServerGUI.getJTextArea().setText(ServerGUI.getJTextArea().getText() + new String(b) + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
