package com.leetcode.algorithms.palindromePairs_336;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashMap extends Solution {
    @Override
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> m = new java.util.HashMap<>();
        for (int i = 0; i < words.length; i++) {
            m.put(new StringBuilder(words[i]).reverse().toString(), i);
        }

        Set<List<Integer>> ret = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            int l = w.length();

            for (int j = -1; j < l; j++) {
                if (isPalindrome(w, 0, j)) {
                    String sub = w.substring(j + 1);
                    if (m.containsKey(sub) && m.get(sub) != i) {
                        List<Integer> p = new ArrayList<>();
                        p.add(m.get(sub));
                        p.add(i);
                        ret.add(p);
                    }
                }
            }
            for (int j = l; j >= 0; j--) {
                if (isPalindrome(w, j, l - 1)) {
                    String sub = w.substring(0, j);
                    if (m.containsKey(sub) && m.get(sub) != i) {
                        List<Integer> p = new ArrayList<>();
                        p.add(i);
                        p.add(m.get(sub));
                        ret.add(p);
                    }
                }
            }
        }

        List<List<Integer>> a = new ArrayList<>();
        a.addAll(ret);
        return a;
    }

    private boolean isPalindrome(String w, int lo, int hi) {
        while (lo < hi) {
            if (w.charAt(lo) != w.charAt(hi)) {
                return false;
            }
            lo += 1;
            hi -= 1;
        }
        return true;
    }
}
