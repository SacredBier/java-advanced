package com.soft1841.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("10.40.148.0",1912);
        InputStream in = socket.getInputStream();
        byte[] b = new byte[1024];
        in.read(b);
        System.out.println("已和服务器建立连接:" + socket.getRemoteSocketAddress());
        System.out.println("服务器发送:" + new String(b));
        in.close();
        socket.close();
    }
}
