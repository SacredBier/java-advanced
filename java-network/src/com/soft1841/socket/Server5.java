package com.soft1841.socket;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server5 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1912);
        System.out.println("服务器启动");
        while (true){
            Socket socket = serverSocket.accept();
            ServerThread5 serverThread5 = new ServerThread5(socket);
            new Thread(serverThread5).start();
        }
    }
}
class ServerThread5 implements Runnable{
    private Socket socket;

    public ServerThread5(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("客户端"+socket.getInetAddress()+"连接成功！");
        try {
            File file = new File("D:/1.jpg");
            InputStream inputStream = new FileInputStream(file);
            byte[] b = new byte[(int) file.length()];
            inputStream.read(b);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(b);
            inputStream.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}