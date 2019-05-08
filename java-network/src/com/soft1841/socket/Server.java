package com.soft1841.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1912);
        System.out.println("服务器启动,端口号:" + ss.getLocalPort());
        OutputStream out;
        System.out.println("请输入要广播的内容");
        Scanner scanner = new Scanner(System.in);
        String info = scanner.nextLine();
        scanner.close();
        while (true) {
            Socket socket = ss.accept();
            System.out.println("客户端"+socket.getInetAddress()+"上线了!");
            out = socket.getOutputStream();
            out.write(info.getBytes());
            out.close();
            socket.close();
        }
    }
}

