package com.leetcode.algorithms.studentAttendanceRecordII_552;

import com.pattern.algorithms.DP;

@DP
public class UseDP extends Solution {
    @Override
    public int checkRecord(int n) {
        int[] dp = new int[7], dp1 = new int[7];
        dp[0] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 1;
        dp[6] = 1;

        int m = (int) Math.pow(10, 9) + 7;
        for (int i = 2; i <= n; i++) {
            dp1[0] = dp[2];
            dp1[1] = dp[0];
            dp1[2] = ((dp[0] + dp[1]) % m + dp[2]) % m;
            dp1[3] = dp1[2];
            dp1[4] = (dp[3] + dp[6]) % m;
            dp1[5] = dp[4];
            dp1[6] = (((dp[3] + dp[4]) % m + dp[5]) % m + dp[6]) % m;
            int[] tmp = dp;
            dp = dp1;
            dp1 = tmp;
        }

        int ret = (dp[3] + dp[4]) % m;
        ret += dp[5];
        ret %= m;
        ret += dp[6];
        ret %= m;
        return ret;
    }
}
