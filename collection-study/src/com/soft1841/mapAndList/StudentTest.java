package com.soft1841.mapAndList;

import java.util.*;

/**
 * @author SacredBier
 * 2019/3/19
 */
public class StudentTest {
    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        List<Student> list2 = new ArrayList<>();
        list1.add(new Student(1, "白建坤"));
        list1.add(new Student(2, "蔡一帆"));
        list1.add(new Student(3, "杨俣韬"));
        list2.add(new Student(4, "孟妮"));
        list2.add(new Student(5, "岳凡"));
        list2.add(new Student(6, "曾月"));
        Map<String, List<Student>> map = new HashMap<>();
        map.put("男生", list1);
        map.put("女生", list2);
        Iterator<Map.Entry<String, List<Student>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Student>> entry = iterator.next();
            System.out.println(entry.getKey());
            Iterator<Student> listIterator = entry.getValue().iterator();
            while (listIterator.hasNext()){
                System.out.println(listIterator.next());
            }

        }
    }
}
