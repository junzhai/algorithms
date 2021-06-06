package com.real.twilio_2021;

import java.util.*;

/**
 * Sort items first by value frequency, then by value ascendingly
 */
public class SortItems {
    List<Integer> sort(List<Integer> items) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int v : items) {
            count.put(v, count.getOrDefault(v, 0) + 1);
        }

        Collections.sort(items, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int ret = count.get(o1) - count.get(o2);
                if (ret == 0) {
                    ret = o1 - o2;
                }
                return ret;
            }
        });

        return items;
    }
}
