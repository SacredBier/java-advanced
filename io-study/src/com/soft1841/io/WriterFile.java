package com.soft1841.io;

import java.io.*;
import java.util.Scanner;

/**
 * @author SacredBier
 * 2019/3/26
 */
public class WriterFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要写入文件的内容");
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        File srcFile = new File("D:/hello.txt");
        Writer out = new FileWriter(srcFile);
        out.write(chars);
        out.close();
    }
}
