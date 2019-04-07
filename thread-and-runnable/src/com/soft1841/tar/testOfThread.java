package com.soft1841.tar;

public class testOfThread extends Thread {
    private int count = 10;

    public void run() {
        while (true) {
            System.out.println(count + " ");
            if (--count == 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        testOfThread test = new testOfThread();
        test.start();
    }
}
