package com.soft1841.tar;

public class RAandTRace {
}

class RabbitThread implements Runnable {
    TortoiseThread tortoiseThread = new TortoiseThread();

    public void setTortoiseThread(TortoiseThread tortoiseThread) {
        this.tortoiseThread = tortoiseThread;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            try {
                Thread.sleep(100);
                System.out.println("兔子跑了" + (i + 1) * 10 + "米");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 7){
                System.out.println("兔子开始睡觉");
                Thread thread = new Thread(tortoiseThread);
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class TortoiseThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("乌龟跑了" + (i + 1) * 10 + "米");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}