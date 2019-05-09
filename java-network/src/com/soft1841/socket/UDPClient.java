package com.soft1841.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 1912;
        byte[] data = "用户名:admin,密码:123456".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
        DatagramSocket socket = new DatagramSocket();
        socket.send(packet);
        byte[] data2 = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(data2,data2.length);
        socket.receive(packet1);
        String reply = new String(data2,0,packet1.getLength());
        System.out.println("我是客户端,服务器说:" + reply);
        socket.close();
    }
}
