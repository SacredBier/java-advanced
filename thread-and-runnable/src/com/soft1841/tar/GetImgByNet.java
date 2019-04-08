package com.soft1841.tar;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetImgByNet extends Object implements Runnable{
    public static void main(String[] args) throws IOException {
        GetImgByNet getImgByNet = new GetImgByNet();
        getImgByNet.run();
    }


    @Override
    public void run() {
        try {
            URL url = new URL("https://cdn2.jianshu.io/assets/web/nav-logo-4c7bbafe27adc892f3046e6978459bac.png");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();
            ByteArrayOutputStream out1 = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inStream.read(buffer)) != -1) {
                out1.write(buffer, 0, length);
            }
            inStream.close();
            byte[] date = out1.toByteArray();
            File imageFile = new File("D:\\1.png");
            OutputStream out2 = new FileOutputStream(imageFile);
            out2.write(date);
            out2.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}