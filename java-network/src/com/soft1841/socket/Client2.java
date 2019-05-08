package com.soft1841.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",1912);
        OutputStream out = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要发送的内容");
        System.out.print(">");
        String info = scanner.nextLine();
        out.write(info.getBytes());
        out.close();
        socket.close();
    }
}
