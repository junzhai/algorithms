package com.leetcode.longestPalindromicSubsequence_516;

import java.util.HashMap;
import java.util.Map;

public class Recursive2DP extends Solution {
    @Override
    public int longestPalindromeSubseq(String s) {
        return inner(new HashMap<Integer, Integer>(), s, 0, s.length() - 1);
    }

    public int inner(Map<Integer, Integer> dp, String s, int b, int e) {
        if (e < b) {
            return 0;
        }

        if (e == b) {
            return 1;
        }

        int index = b * s.length() + e;
        if (dp.containsKey(index)) {
            return dp.get(index);
        }

        int ret = 1, maxLast = 0;
        for (int i = b; i <= e; i++) {
            int last = s.lastIndexOf(s.charAt(i), e);
            if (last > i && last > maxLast) {
                ret = Math.max(ret, inner(dp, s, i + 1, last - 1) + 2);
                maxLast = last;
                if (maxLast == e) {
                    break;
                }
            }
        }
        dp.put(index, ret);
        return ret;
    }
}
