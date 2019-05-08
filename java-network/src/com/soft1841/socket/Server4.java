package com.soft1841.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server4 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1912);
        System.out.println("服务器已启动");
        while (true){
            Socket socket =serverSocket.accept();
            ServerThread4 serverThread4 = new ServerThread4(socket);
            new Thread(serverThread4).start();
        }
    }
}

class ServerThread4 implements Runnable{
    private Socket socket ;
    public ServerThread4 (Socket socket){
        this.socket =socket;
    }
    @Override
    public void run() {
        System.out.println("客户端："+socket.getInetAddress()+"连接成功！");
        String info = "通知";
        OutputStream outputStream =null;
        try {
            outputStream = socket.getOutputStream();
        }catch (IOException e){
            e.printStackTrace();
        }
        PrintStream printStream = new PrintStream(outputStream);
        printStream.print(info);
        printStream.close();
    }
}
