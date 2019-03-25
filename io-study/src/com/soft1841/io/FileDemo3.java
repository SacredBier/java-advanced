package com.soft1841.io;

import java.io.File;

public class FileDemo3 {
    public static void main(String[] args) {
        String[] strings = {"image", "video", "document"};
        for (int i = 0; i < strings.length; i++) {
            File path = new File("D:/upload/" + strings[i]);
            if (!path.exists()) {
                path.mkdirs();
            }
        }
    }
}
