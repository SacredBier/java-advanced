package com.soft1841.tar;

public class Team {

    public static void main(String[] args) {
        TeamA a = new TeamA();
        TeamB b = new TeamB();
        b.run();
        a.run();
    }
}

class TeamA extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 11; i++) {
            int j = i + 1;
            System.out.print("A" + j + "  ");
        }
    }
}

class TeamB extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 11; i++) {
            int j = i + 1;
            System.out.print("B" + j + "  ");
        }
    }
}