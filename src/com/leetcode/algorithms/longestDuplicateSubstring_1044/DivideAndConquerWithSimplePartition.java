package com.leetcode.algorithms.longestDuplicateSubstring_1044;

import com.leetcode.algorithms.pattern.DivideAndConquer;

import java.util.HashMap;
import java.util.Map;

@DivideAndConquer
public class DivideAndConquerWithSimplePartition extends Solution {
    @Override
    public String longestDupSubstring(String S) {
        char[] s = S.toCharArray();
        int len = s.length;
        int[] cache = new int[len], count = new int[26];
        for (int i = 0; i < len; i++) {
            cache[i] = i;
            count[s[i] - 'a'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] == len) {
                return S.substring(1);
            }
        }

        int[] r = helper(s, cache, len, new HashMap<>());
        return String.valueOf(s, r[1], r[0]);
    }

    private int[] helper(char[] s, int[] pos, int len, Map<Long, Integer> dp) {
        if (len < 2) {
            return new int[]{-1, pos[0]};
        }

        int lim = s.length;
        if (pos[len - 1] == lim) {
            len -= 1;
        }

        if (len == 2) {
            int l = pos[0], r = pos[1];
            if (s[l] != s[r]) {
                return new int[]{0, l};
            }
            long key = (long) l * lim + r;
            if (dp.containsKey(key)) {
                return new int[]{dp.get(key), pos[0]};
            }

            int c = 0;
            while (r < lim && s[l] == s[r]) {
                c += 1;
                l += 1;
                r += 1;
            }
            dp.put(key, c);
            return new int[]{c, pos[0]};
        }

        int[][] cache = new int[26][len];
        int[] l = new int[26];
        for (int i = 0; i < len; i++) {
            int idx = s[pos[i]] - 'a';
            cache[idx][l[idx]] = pos[i] + 1;
            l[idx] += 1;
        }

        int maxLen = -2, from = 0;
        for (int i = 0; i < 26; i++) {
            if (l[i] == 0) {
                continue;
            }

            int[] r = helper(s, cache[i], l[i], dp);
            if (r[0] > maxLen) {
                from = r[1] - 1;
                maxLen = r[0];
            }
        }
        return new int[]{maxLen + 1, from};
    }
}
