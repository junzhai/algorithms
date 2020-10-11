package com.leetcode.algorithms.maximumProductofWordLengths_318;

import java.util.Arrays;
import java.util.Comparator;

public class EnhancedBruteForce_2 extends Solution {
    @Override
    public int maxProduct(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        int len = words.length;
        int[] m = new int[len], l = new int[len];
        for (int i = 0; i < len; i++) {
            for (int c = 'a'; c <= 'z'; c++) {
                m[i] <<= 1;
                m[i] += words[i].indexOf(c) >= 0? 1 : 0;
            }
            l[i] = words[i].length();
        }

        int ret = 0, b = 0, e = len - 1, min = 0;
        while (b < e) {
            min = ret / l[b];
            for (int i = b + 1; i <= e && l[b] > min; i++) {
                if ((m[b] & m[i]) == 0) {
                    ret = Math.max(ret, l[b] * l[i]);
                    e = i - 1;
                    break;
                }
            }
            b += 1;
        }

        return ret;
    }
}
