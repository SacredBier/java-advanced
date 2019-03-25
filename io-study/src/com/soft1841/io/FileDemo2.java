package com.soft1841.io;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class FileDemo2 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        File path = new File("D:/" + month + "_" + day);
        if (!path.exists()) {
            path.mkdirs();
        }
        File file = new File(path + "/" + hour + "_" + minute + "hello.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("盘符不存在");
            }
        }
    }
}
