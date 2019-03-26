package com.soft1841.io;

import java.io.*;

/**
 * @author SacredBier
 * 2019/3/26
 */
public class FileCopy {
    public static void main(String[] args) throws IOException{
        //指定源文件
        File srcFile = new File("D:/bg.jpg");
        //指定目标文件
        File destFile = new File("D:/测试用/bg.jpg");
        //创建一个字节输数组，大小为源文件
        byte[] bytes = new byte[(int) srcFile.length()];
        //创建字节输入流
        InputStream inputStream = new FileInputStream(srcFile);
        //将源文件读入字节数组
        inputStream.read(bytes);
        //创建字节输出流
        OutputStream outputStream = new FileOutputStream(destFile);
        //将字节输出
        outputStream.write(bytes);
        //关闭输入输出流
        inputStream.close();
        outputStream.close();
    }
}
