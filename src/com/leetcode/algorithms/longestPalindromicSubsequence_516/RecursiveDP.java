package com.leetcode.algorithms.longestPalindromicSubsequence_516;

import java.util.HashMap;
import java.util.Map;

public class RecursiveDP extends Solution {
    @Override
    public int longestPalindromeSubseq(String s) {
        return inner(new HashMap<Integer, Integer>(), s, 0, s.length() - 1);
    }

    public int inner(Map<Integer, Integer> dp, String s, int b, int e) {
        if (b > e) {
            return 0;
        }

        if (b == e) {
            return 1;
        }

        int index = b * s.length() + e;
        if (dp.containsKey(index)) {
            return dp.get(index);
        }

        int ret = 1;
        if (s.charAt(b) == s.charAt(e)) {
            ret = Math.max(ret, inner(dp, s, b + 1, e - 1) + 2);
        } else {
            ret = Math.max(ret, inner(dp, s, b + 1, e));
            ret = Math.max(ret, inner(dp, s, b, e - 1));
        }

        dp.put(index, ret);
        return ret;
    }
}
