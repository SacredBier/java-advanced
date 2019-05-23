package com.soft1841.design5;

public class LoggerCloud implements Logger {
    @Override
    public void log(String message) {
        System.out.println("输出日志到云平台" + message);
    }
}
