package com.soft1841;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton object = Singleton.getInstance();
        object.showMessage();
    }
}
