package com.soft1841.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetLest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("C");
        set.add("B");
        set.add("A");
        System.out.println(set);
        //用for循环遍历set集合
        Object[] array = set.toArray();
        for (int i = 0, len = array.length; i < len; i++) {
            System.out.println(array[i] + "  ");
        }
        //用Iterator迭代器遍历集合
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "   ");
        }
        System.out.println();
        //用Lambda表达式遍历集合
        set.forEach(str -> System.out.print(str + "  "));
    }
}
