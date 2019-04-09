package com.soft1841.tar;

/**
 * 多线程售票
 * 继承Thread类的方法实现
 */
public class TicketThreadTest1 {
    public static void main(String[] args) {
        TicketThread1 tt1 = new TicketThread1();
        tt1.start();
        TicketThread1 tt2 = new TicketThread1();
        tt2.start();
        TicketThread1 tt3 = new TicketThread1();
        tt3.start();
    }
}
//数据无法共享
class TicketThread1 extends Thread{
    private int tickets = 10;

    @Override
    public void run() {
        while (tickets > 0){
            System.out.println(Thread.currentThread().getName() + "售票，当前票数" + --tickets);
        }
    }
}