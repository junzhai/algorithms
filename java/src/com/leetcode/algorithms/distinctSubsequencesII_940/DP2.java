package com.leetcode.algorithms.distinctSubsequencesII_940;

import com.pattern.algorithms.DP;

@DP
public class DP2 extends Solution {
    @Override
    public int distinctSubseqII(String S) {
        int len = S.length(), m = (int) Math.pow(10, 9) + 7, ret = 1;
        int[] dp = new int[26];
        dp[S.charAt(0) - 'a'] = 1;
        for (int i = 1; i < len; i++) {
            int index = S.charAt(i) - 'a';
            int tmp = (ret + ret + 1 - dp[index]) % m;
            if (tmp < 0) {
                tmp += m;
            }
            dp[index] = ret + 1;
            ret = tmp;
        }

        return ret;
    }
}
