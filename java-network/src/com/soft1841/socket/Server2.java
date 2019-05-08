package com.soft1841.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1912);
        System.out.println("服务器启动,端口号:" + ss.getLocalPort());
        while (true) {
            Socket socket = ss.accept();
            byte[] b = new byte[1024];
            System.out.println("客户端" + socket.getInetAddress() + "上线了!");
            InputStream in = socket.getInputStream();
            in.read(b);
            System.out.println(new String(b));
            in.close();
        }
    }
}
