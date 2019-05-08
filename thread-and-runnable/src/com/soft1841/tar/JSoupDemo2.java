package com.soft1841.tar;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

public class JSoupDemo2 {
    public static void main(String[] args)  throws Exception{
        File file;
        InputStream inputStream;
        OutputStream outputStream;
        String url1 = "http://www.faloo.com/";
        Connection connection = Jsoup.connect(url1);
        Document document = connection.get();
        //Element elementDiv = document.getElementById("container");
        Elements elements = document.getElementsByClass("book2");
        System.out.println(elements.size());
        for (Element e:elements){
            Element imgElement = e.child(0).child(0);
            UUID uuid = UUID.randomUUID();
            String imgName = uuid +".jpg";
            file = new File("D:\\Downloads\\"+imgName);
            URL url2 = new URL(imgElement.attr("src"));
            URLConnection uc = url2.openConnection();
            inputStream = uc.getInputStream();
            outputStream =  new FileOutputStream(file);
            int temp;
            byte[] buf  = new byte[1024];
            while ((temp = inputStream.read(buf))!= -1){
                outputStream.write(buf,0,temp);

            }
            outputStream.close();
            inputStream.close();

        }
    }
}
