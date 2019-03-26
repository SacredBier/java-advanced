package com.soft1841.io;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SacredBier
 * 2019/3/26
 */
public class WriterFile {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("D:/hello.txt");
        Reader in = new FileReader(srcFile);
        char[] srcChars = new char[(int) srcFile.length()];
        in.read(srcChars);
        System.out.println("文档中已有内容：");
        System.out.println(srcChars);
        Writer out = new FileWriter(srcFile);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要写入文件的内容");
        String str = scanner.nextLine();
        char[] newChars = str.toCharArray();
        char[] chars = Arrays.copyOf(srcChars, srcChars.length + newChars.length);
        System.arraycopy(newChars, 0, chars, srcChars.length, newChars.length);
        out.write(chars);
        out.close();
        scanner.close();
    }
}
