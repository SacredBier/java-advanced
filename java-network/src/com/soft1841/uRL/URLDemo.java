package com.soft1841.uRL;

import java.io.IOException;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=%E8%B0%B7%E6%AD%8C&rsv_pq=95bed2b00002665c&rsv_t=9570MtTKJMkK0SVDtRxyuNdyb4fteLO02pINFtVnTP6aRy2L3K2ny6oem9g&rqlang=cn&rsv_enter=1&rsv_sug3=6&rsv_sug1=3&rsv_sug7=101&rsv_sug2=0&inputT=1399&rsv_sug4=3583");
            System.out.println("URL为:" + url.toString());
            System.out.println("协议为:" + url.getProtocol());
            System.out.println("验证信息:" + url.getAuthority());
            System.out.println("文件名及请求参数:" + url.getFile());
            System.out.println("主机名:" + url.getHost());
            System.out.println("路径:" + url.getPath());
            System.out.println("端口:" + url.getPort());
            System.out.println("默认端口:" + url.getDefaultPort());
            System.out.println("请求参数:" + url.getQuery());
            System.out.println("定位位置:" + url.getRef());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
