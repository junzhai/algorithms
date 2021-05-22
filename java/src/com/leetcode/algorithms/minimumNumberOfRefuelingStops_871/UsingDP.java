package com.leetcode.algorithms.minimumNumberOfRefuelingStops_871;

import com.pattern.algorithms.DP;

import java.util.Arrays;

@DP
public class UsingDP extends Solution {
    @Override
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (target <= startFuel) {
            return 0;
        }

        int len = stations.length;
        if (len == 0 || startFuel < stations[0][0]) {
            return -1;
        }

        int[] dp = new int[len];
        Arrays.fill(dp, -1);
        dp[0] = startFuel - stations[0][0];

        int l = 0, r = 0;
        for (int i = 1; i < len; i++) {
            int gas = stations[i - 1][1], diff = gas - stations[i][0] + stations[i - 1][0];
            while (l <= r && dp[r] + diff < 0) {
                r -= 1;
            }
            if (l > r) {
                return -1;
            }
            int rr = r + 1, ll = rr;
            for (int j = r; j >= l; j--) {
                if (dp[j] < 0) {
                    continue;
                }
                int v = dp[j] + diff;
                if (v < 0) {
                    dp[j] = -1;
                } else {
                    dp[j + 1] = Math.max(dp[j + 1], v);
                    if (v - gas < 0) {
                        dp[j] = -1;
                        ll = j + 1;
                    } else {
                        dp[j] = v - gas;
                        ll = j;
                    }
                }
            }
            l = ll;
            r = rr;
        }

        int t = target - stations[len - 1][0];
        for (int i = l; i <= r; i++) {
            if (dp[i] >= t) {
                return i;
            }
            if (dp[i] + stations[len - 1][1] >= t) {
                return i + 1;
            }
        }
        return -1;
    }
}
