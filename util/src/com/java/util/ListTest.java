package com.java.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author SacredBier
 * list练习
 * 2019/3/18
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("HTML");
        list.add("高数");
        //用util的Random类随机产生一个[0,list.size()-1]的随机整数
        int length = list.size();
        Random random = new Random();
        int index = random.nextInt(length);
        System.out.println(list.get(index));
        for (int i = 0; i < length ; i++){
            System.out.println(list.get(i));
        }
    }
}
