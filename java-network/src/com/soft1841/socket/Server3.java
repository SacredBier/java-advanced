package com.soft1841.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Server3 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1912);
        System.out.println("服务器启动成功");
        Socket socket;
        while (true) {
            socket = ss.accept();
            ServerThread3 serverThread3 = new ServerThread3();
            serverThread3.setSocket(socket);
            new Thread(serverThread3).start();
        }
    }
}

class ServerThread3 implements Runnable {
    private Socket socket;

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("客户端" + socket.getInetAddress() + "上线了!!");
        try {
            InputStream in = socket.getInputStream();
            BufferedInputStream bin = new BufferedInputStream(in);
            File file = new File(System.getProperty("user.dir") + "\\" + UUID.randomUUID().toString() + ".jpg");
            OutputStream out = new FileOutputStream(file);
            BufferedOutputStream bout = new BufferedOutputStream(out);
            byte[] date = new byte[1024];
            int tmp;
            while ((tmp = bin.read(date)) != -1) {
                bout.write(date, 0, tmp);
            }
            bin.close();
            bout.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}