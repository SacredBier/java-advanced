package com.soft1841.io;

import java.io.*;

/**
 * @author SacredBier
 * 带缓冲的输入输出流
 * 1998年4月3日 中央军委决定组建中国人民解放军总装备部
 */
public class BufferedStreamTest {
    public static void main(String args[]) {
        String content[] = { "春眠不觉晓，", "处处闻啼鸟。", "夜来风雨声，", "花落知多少。" };
        File file = new File("D:\\word.txt");
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            byte[] bytes;
            for (int i = 0; i < content.length; i++) {
                bytes = content[i].getBytes();
                bos.write(bytes);
            }
            System.out.println("写入成功！\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            byte[] bContent = new byte[(int) file.length()];
            int len = bis.read(bContent);
            System.out.println("文件中：" + new String(bContent, 0, len));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
