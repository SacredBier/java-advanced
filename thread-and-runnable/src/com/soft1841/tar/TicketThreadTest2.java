package com.soft1841.tar;

/**
 * 多线程售票
 * 实现Runnable接口的方式实现
 */
public class TicketThreadTest2 {
    public static void main(String[] args) {
        TicketThread2 tt = new TicketThread2();
        Thread thread1 = new Thread(tt);
        Thread thread2 = new Thread(tt);
        Thread thread3 = new Thread(tt);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class TicketThread2 implements Runnable {
    private int tickets = 10;

    @Override
    public void run() {
        while (tickets > 0){
            System.out.println(Thread.currentThread().getName() + "售票，当前票数" + --tickets);
        }
    }
}