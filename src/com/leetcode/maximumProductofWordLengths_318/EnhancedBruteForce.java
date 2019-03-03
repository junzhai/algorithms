package com.leetcode.maximumProductofWordLengths_318;

import java.util.Arrays;
import java.util.Comparator;

public class EnhancedBruteForce extends Solution {
    @Override
    public int maxProduct(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        int[] m = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int c = 'a'; c <= 'z'; c++) {
                m[i] <<= 1;
                m[i] += words[i].indexOf(c) >= 0? 1 : 0;
            }
        }

        int ret = 0;
        for (int i = 1; i < words.length && words[i].length() > 0 && words[0].length() > ret / words[i].length(); i++) {
            for (int j = 0; j < i && words[j].length() > ret / words[i].length(); j++) {
                if ((m[j] & m[i]) == 0) {
                    ret = Math.max(ret, words[j].length() * words[i].length());
                    break;
                }
            }
        }

        return ret;
    }
}
