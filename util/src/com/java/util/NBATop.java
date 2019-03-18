package com.java.util;

import java.util.ArrayList;
import java.util.List;

public class NBATop {
    public static void main(String[] args) {
        System.out.println("————————————NBA巨星————————————");
        System.out.println("球员  绰号    得分    篮板    助攻");
        List<NBAStar> list = new ArrayList<>();
        NBAStar nbaStar1 = new NBAStar("乔丹", "飞人", 30.1, 5.3, 6.2);
        list.add(nbaStar1);
        int length = list.size();
        for (int i = 0; i < length; i++) {
            System.out.println(nbaStar1.getName() + "  " + nbaStar1.getNickname() + "    " +nbaStar1.getPoint() + "    " +nbaStar1.getRebound() + "    " +nbaStar1.getAssist());
        }
    }
}