package com.soft1841.io;

import java.io.File;
import java.io.IOException;

/**
 * @author SacredBier
 * 2019/3/25
 */
public class FileDemo1 {
    public static void main(String[] args) {
        File file = new File("D:/README.md");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("盘符不存在");
            }
        }
    }
}
