package com.leetcode.algorithms.distinctSubsequencesII_940;

import com.pattern.algorithms.DP;

@DP
public class DP1 extends Solution {

    @Override
    public int distinctSubseqII(String S) {
        char[] s = S.toCharArray();
        int len = s.length, m = (int) Math.pow(10, 9) + 7;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            int[] r = new int[26];
            dp[i][i] = 1;
            r[s[i] - 'a'] = 1;
            for (int j = i + 1; j < len; j++) {
                int index = s[j] - 'a', tmp = i > 0 ? dp[i - 1][j - 1] : 1;
                dp[i][j] = dp[i][j - 1] + (tmp - r[index]);
                dp[i][j] %= m;
                if (dp[i][j] < 0) {
                    dp[i][j] += m;
                }
                r[index] = tmp;
            }
        }

        int ret = 0;
        for (int i = 0; i < len; i++) {
            ret += dp[i][len - 1];
            ret %= m;
        }

        return ret;
    }
}
