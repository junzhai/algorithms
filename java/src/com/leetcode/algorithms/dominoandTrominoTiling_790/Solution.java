package com.leetcode.algorithms.dominoandTrominoTiling_790;

import com.pattern.algorithms.DP;
import org.junit.Assert;

@DP
public class Solution {
    public int numTilings(int N) {
        int m = (int) Math.pow(10, 9) + 7;
        int[][] dp = new int[N + 1][3];
        if (N > 0) {
            dp[1][0] = 1;
        }
        if (N > 1) {
            dp[2][0] = 2;
            dp[2][1] = 1;
            dp[2][2] = 1;
        }
        for (int i = 3; i <= N; i++) {
            dp[i][0] = dp[i - 1][1] + dp[i - 1][2];
            dp[i][0] %= m;
            dp[i][0] += dp[i - 1][0];
            dp[i][0] %= m;
            dp[i][0] += dp[i - 2][0];
            dp[i][0] %= m;
            dp[i][1] = dp[i - 1][2] + dp[i - 2][0];
            dp[i][1] %= m;
            dp[i][2] = dp[i - 1][1] + dp[i - 2][0];
            dp[i][2] %= m;
        }

        return dp[N][0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret;
        ret = s.numTilings(4);
        Assert.assertEquals(11, ret);
    }
}
