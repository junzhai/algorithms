package com.leetcode.algorithms.countDifferentPalindromicSubsequences_730;

import com.pattern.DP;
import com.pattern.Histogram;

@Histogram
@DP
public class Histogram1 extends Solution {
    @Override
    public int countPalindromicSubsequences(String S) {
        int len = S.length(), m = (int) Math.pow(10, 9) + 7, ret = 0;
        char[] s = S.toCharArray();
        int[] dp = new int[len];

        for (int i = 0, sum = 0; i < len; i++) {
            for (int k = len - 1, interval = 0, preInterval = 1; k > i; k--) {
                if (s[k] == s[i]) {
                    int tmp = dp[k];
                    dp[k] = (interval + preInterval) % m;
                    preInterval = tmp;
                    interval = 0;
                } else {
                    interval += dp[k];
                    interval %= m;
                    sum += dp[k];
                    sum %= m;
                }
            }
            dp[i] = sum + 1;
            sum = 0;
        }

        for (int i = 0; i < len; i++) {
            ret += dp[i];
            ret %= m;
        }
        return ret;
    }
}
