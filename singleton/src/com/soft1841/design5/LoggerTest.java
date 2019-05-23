package com.soft1841.design5;

public class LoggerTest {
    public static void main(String[] args) {
        Logger logger = new LoggerFileSystem();
        logger.log("不加装饰的本地登录……");
        Logger logger1 = new TimeLoggerDecorator(new LoggerFileSystem());
        logger1.log("加装饰的本地登录……");
        Logger logger2 = new TimeLoggerDecorator(new LoggerCloud());
        logger2.log("加装饰的云平台登录……");
    }
}
