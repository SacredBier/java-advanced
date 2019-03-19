package com.soft1841.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(-10);
        set.add(-5);
        set.add(0);
        set.add(-3);
        set.add(3);
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "   ");
        }
    }
}
