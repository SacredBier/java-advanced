package com.soft1841.listSetAndMap;

import java.util.*;

public class ListTest {
    public static void main(String[] args) {
        Set<Integer> ids = new TreeSet<>();
        ids.add(0);
        ids.add(1);
        ids.add(2);
        ids.add(3);
        List<Cartoon> cartoons = new ArrayList<>();
        cartoons.add(new Cartoon("面包", 15.7, 7797));
        cartoons.add(new Cartoon("NOEL", 9.52, 12193));
        cartoons.add(new Cartoon("最终", 8.5, 30170));
        cartoons.add(new Cartoon("猫伴", 9.73, 1984));
        Map<Integer, String> sample = new HashMap<>();
        Object[] array = ids.toArray();
        for (int i = 0, len = array.length; i < len; i++) {
            sample.put(Integer.parseInt(array[i].toString()), cartoons.get(i).getName());
        }
        System.out.println(sample);
        System.out.println("**************************作品表**************************");
        System.out.println("序号\t\t\t\t书名\t\t\t\t\t评分\t\t\t\t\t销量");
        Iterator<Map.Entry<Integer, String>> iterator2 = sample.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<Integer, String> entry = iterator2.next();
            System.out.println(entry.getKey() + "\t\t\t\t" + entry.getValue() + "\t\t\t\t\t"
                    + cartoons.get(entry.getKey()).getPoint() + "\t\t\t\t" +
                    cartoons.get(entry.getKey()).getVolume());
        }
    }
}
