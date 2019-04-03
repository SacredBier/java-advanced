package com.soft1841.io;

import java.io.*;

/**
 * @author SacredBier
 */

public class BufferedTest {
    public static void main(String[] args) {
        String[] content = {"春眠不觉晓，", "处处闻啼鸟。", "夜来风雨声，", "花落知多少。"};
        File file = new File("D:\\word.txt");
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fw);
            for (int i = 0; i < content.length; i++) {
                bufferedWriter.write(content[i]);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String s = null;
            int k = 0;
            while ((s = bufferedReader.readLine()) != null) {
                k++;
                System.out.println("第" + k + "行" + s);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
