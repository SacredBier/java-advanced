package com.soft1841.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List接口类的第二次练习
 * @author SacredBier
 * 2019/3/19
 */

public class ListTestTwo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        //直接输出
        System.out.println(list);
        //for通过循环遍历集合
        for(int i = 0 ; i < list.size() ; i++){
            System.out.print(list.get(i));
        }
        System.out.println();
        //通过Iterator迭代器遍历集合
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }
        System.out.println();
        //通过Lambda表达式遍历集合
        list.forEach(str -> System.out.print(str));
    }
}
