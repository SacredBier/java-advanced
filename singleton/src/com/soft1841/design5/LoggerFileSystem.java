package com.soft1841.design5;

public class LoggerFileSystem implements Logger {
    @Override
    public void log(String message) {
        System.out.println("输出日志到本地文件系统" + message);
    }
}
