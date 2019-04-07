package com.soft1841.tar;

public class testOfRunnable extends Object implements Runnable {
    private int count = 10;

    @Override
    public void run() {

        while (true) {
            System.out.println(count + " ");
            if (--count == 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        testOfRunnable test = new testOfRunnable();
        test.run();
    }
}
