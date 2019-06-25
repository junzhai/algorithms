package com.leetcode.algorithms.uncrossedLines_1035;

import org.junit.Assert;

public class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int la = A.length, lb = B.length;
        int[][] dp = new int[la][lb];

        for (int c = 0, last = -1; c < lb; c++) {
            if (A[0] == B[c]) {
                last = c;
            }
            if (last >= 0) {
                dp[0][c] = 1;
            }
        }

        for (int r = 1; r < la; r++) {
            for (int c = 0, last = -1; c < lb; c++) {
                dp[r][c] = dp[r - 1][c];
                if (A[r] == B[c]) {
                    last = c;
                }
                if (last >= 0) {
                    dp[r][c] = Math.max(dp[r][c], last == 0 ? 1 : dp[r - 1][last - 1] + 1);
                }
            }
        }

        return dp[la - 1][lb - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret;

        ret = s.maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1});
        Assert.assertEquals(2, ret);

        ret = s.maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4});
        Assert.assertEquals(2, ret);
    }
}
