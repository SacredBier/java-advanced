package com.soft1841.io;

import java.io.*;

/**
 * @author SacredBier
 * 文本复制操作
 * 2019/3/26
 */
public class TXTCopy {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("D:/hello.txt");
        if (srcFile.exists()) {
            File destFile = new File("D:/hello副本.txt");
            Reader in = new FileReader(srcFile);
            char[] chars = new char[(int) srcFile.length()];
            in.read(chars);
            Writer out = new FileWriter(destFile);
            out.write(chars);
            in.close();
            out.close();
        }else {
            System.err.println("系统找不到指定文件");
        }
    }
}
