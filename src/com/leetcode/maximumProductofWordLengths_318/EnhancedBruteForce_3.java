package com.leetcode.maximumProductofWordLengths_318;

import java.util.Arrays;
import java.util.Comparator;

public class EnhancedBruteForce_3 extends Solution {
    @Override
    public int maxProduct(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        int len = words.length;
        int[] m = new int[len];

        int ret = 0, limit = len;
        for (int i = 0; i < len; i++) {
            m[i] = convert(words[i]);
            for (int j = 0; j < i && j < limit; j++) {
                if ((m[j] & m[i]) == 0) {
                    ret = Math.max(ret, words[j].length() * words[i].length());
                    limit = j;
                    break;
                }
            }
        }

        return ret;
    }

    private int convert(String w) {
        int ret = 0, len = w.length();
        if (len >= 26) {
            for (int c = 'z'; c >= 'a'; c--) {
                ret <<= 1;
                ret += w.indexOf(c) >= 0 ? 1 : 0;
            }
        } else {
            for (int i = 0; i < len; i++) {
                ret |= 1 << w.charAt(i) - 'a';
            }
        }
        return ret;
    }
}
