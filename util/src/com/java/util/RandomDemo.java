package com.java.util;

import java.util.Random;

/**
 * @author SacredBier
 * 随机数类测试
 * 2019.3.10
 */
public class RandomDemo {
    public static void main(String[] args) {
        Random random = new Random();
        int num = random.nextInt(6);
        System.out.println(num);
    }
}
