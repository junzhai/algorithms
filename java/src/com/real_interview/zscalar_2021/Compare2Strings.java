package com.real_interview.zscalar_2021;

import java.util.HashMap;
import java.util.Map;

public class Compare2Strings {

    // Character can be any ascii
    public boolean solution(String a, String b) {
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < b.length(); i++) {
            char ch = b.charAt(i);
            if (!count.containsKey(ch)) {
                return false;
            }

            count.put(ch, count.get(ch) - 1);
        }

        for (char ch : count.keySet()) {
            if (count.get(ch) != 0) {
                return false;
            }
        }

        return true;
    }
}
