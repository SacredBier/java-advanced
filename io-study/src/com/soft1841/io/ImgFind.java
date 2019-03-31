package com.soft1841.io;

import java.io.File;

public class ImgFind {
    public static void main(String[] args) {
        String path ="C:\\Users\\SacredBier\\Documents\\嵌字\\面包带来和平\\面包带来和平！第10话";
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f:files){
            if (!f.isDirectory()){
                String srcFileName = f.getName();
                int position = srcFileName.indexOf(".");
                String suffixName = srcFileName.substring(position);
                if (suffixName.equals(".jpg") | srcFileName.equals(".png")){
                    System.out.println(f);
                }
            }
        }
    }
}
