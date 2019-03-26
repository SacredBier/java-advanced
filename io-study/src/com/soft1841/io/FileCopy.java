package com.soft1841.io;

import java.io.*;
import java.util.UUID;

/**
 * @author SacredBier
 * 2019/3/26
 */

public class FileCopy {
    public static void main(String[] args){
        //指定源文件
        File srcFile = new File("D:/bg.jpg");
        //获取源文件名
        String srcFileName = srcFile.getName();
        //将源文件名以"."分割
        int position = srcFileName.indexOf(".");
        //获取扩展名
        String suffixName = srcFileName.substring(position);
        //指定目标文件
        File destFile = new File("D:/测试用/" + UUID.randomUUID().toString() + suffixName);
        //创建一个字节输数组，大小为源文件
        byte[] bytes = new byte[(int) srcFile.length()];
        //创建字节输入流
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(srcFile);
        } catch (FileNotFoundException e) {
            System.err.println("写入出现异常");
        }
        //将源文件读入字节数组
        try {
            inputStream.read(bytes);
        } catch (IOException e) {
            System.err.println("读入出现异常");
        }
        //创建字节输出流
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(destFile);
        } catch (FileNotFoundException e) {
            System.err.println("创建输出出现异常");
        }
        //将字节输出
        try {
            outputStream.write(bytes);
        } catch (IOException e) {
            System.err.println("字节输出出现异常");
        }
        //关闭输入输出流
        try {
            inputStream.close();
        } catch (IOException e) {
            System.err.println("关闭输入流出现异常");
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            System.err.println("关闭输出流出现异常");
        }
    }
}
