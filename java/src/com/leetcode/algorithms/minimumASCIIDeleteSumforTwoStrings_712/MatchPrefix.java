package com.leetcode.algorithms.minimumASCIIDeleteSumforTwoStrings_712;

import com.pattern.algorithms.DP;

import java.util.Arrays;

@DP
public class MatchPrefix extends Solution {
    @Override
    public int minimumDeleteSum(String s1, String s2) {
        int len = s1.length(), total = 0;
        int[][] pos = new int[26][0];

        char[] ss1 = s1.toCharArray();
        for (int i = 0; i < len; i++) {
            total += (int) ss1[i];
            int index = ss1[i] - 'a';
            int[] a = pos[index];
            pos[index] = Arrays.copyOf(a, a.length + 1);
            pos[index][a.length] = i;
        }

        int[] dp = new int[len];
        for (int i = 0; i < s2.length(); i++) {
            int ch = (int) s2.charAt(i);
            total += ch;
            int[] ps = pos[ch - 'a'];
            for (int j = ps.length - 1; j >= 0; j--) {
                int p = ps[j], v = ch + (p > 0 ? dp[p - 1] : 0);
                while (p < len && v > dp[p]) {
                    dp[p] = v;
                    p += 1;
                }
            }
        }

        return total - (dp[len - 1] << 1);
    }
}
