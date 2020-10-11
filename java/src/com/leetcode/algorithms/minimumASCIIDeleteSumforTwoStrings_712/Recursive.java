package com.leetcode.algorithms.minimumASCIIDeleteSumforTwoStrings_712;

public class Recursive extends Solution {
    @Override
    public int minimumDeleteSum(String s1, String s2) {
        int row = s1.length(), col = s2.length();
        int m = maxMatch(s1, 0, s2, 0, new int[row][col]);
        int total = 0;
        for (int i = 0; i < row; i++) {
            total += (int) s1.charAt(i);
        }
        for (int i = 0; i < col; i++) {
            total += (int) s2.charAt(i);
        }
        return total - (m << 1);
    }

    private int maxMatch(String s1, int i1, String s2, int i2, int[][] dp) {
        int row = dp.length, col = dp[0].length;
        if (i1 >= row || i2 >= col) {
            return 0;
        }

        if (dp[i1][i2] > 0) {
            return dp[i1][i2] - 1;
        }

        dp[i1][i2] = maxMatch(s1, i1, s2, i2 + 1, dp);

        int ch = (int) s2.charAt(i2);
        int index = s1.indexOf(ch, i1);
        if (index >= 0) {
            dp[i1][i2] = Math.max(dp[i1][i2], maxMatch(s1, index + 1, s2, i2 + 1, dp) + ch);
        }
        dp[i1][i2] += 1;
        return dp[i1][i2] - 1;
    }
}
