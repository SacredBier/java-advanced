package com.soft1841.tar;

/**
 * 多线程售票
 * 实现Runnable接口并同步线程
 * 加锁可以加在代码块上，也可以加在方法上
 */
public class TicketThreadTest3 {
    public static void main(String[] args) {
        TicketThread3 tt = new TicketThread3();
        Thread thread1 = new Thread(tt, "A点");
        Thread thread2 = new Thread(tt, "B点");
        Thread thread3 = new Thread(tt, "C点");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class TicketThread3 implements Runnable {
    private int tickets = 10;

    @Override
    public void run() {
        while (true) {
            //同步售票代码块
            synchronized (this) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        System.err.println("中断异常");
                    }
                    System.out.println(Thread.currentThread().getName() + "售票，当前票数" + --tickets);
                } else {
                    break;
                }
            }
        }
    }
}