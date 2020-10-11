package com.leetcode.algorithms.minimumNumberOfRefuelingStops_871;

import com.leetcode.algorithms.pattern.BFS;

import java.util.Arrays;

@BFS
public class UsingBFS extends Solution {
    @Override
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (target <= startFuel) {
            return 0;
        }

        int len = stations.length;
        if (len == 0) {
            return -1;
        }

        int[] dp = new int[len], tmp = new int[len];
        Arrays.fill(dp, -1);

        int l = 0, r = -1;
        for (int i = 0; i < len; i++) {
            if (stations[i][0] <= startFuel) {
                tmp[i] = startFuel - stations[i][0] + stations[i][1];
                dp[i] = tmp[i];
                r = i;
            }
        }

        int step = 1;
        while (l <= r) {
            int ll = Integer.MAX_VALUE, rr = Integer.MIN_VALUE;
            int[] tt = new int[len];
            Arrays.fill(tt, -1);

            for (int i = r; i >= l; i--) {
                if (tmp[i] < 0) {
                    continue;
                }

                if (tmp[i] >= target - stations[i][0]) {
                    return step;
                }

                for (int j = i + 1; j < len; j++) {
                    if (tmp[i] < stations[j][0] - stations[i][0]) {
                        break;
                    }
                    int v = tmp[i] - stations[j][0] + stations[i][0] + stations[j][1];
                    if (v > dp[j]) {
                        tt[j] = v;
                        dp[j] = v;
                        rr = Math.max(rr, j);
                        ll = Math.min(ll, j);
                    }
                }
            }
            r = rr;
            l = ll;
            tmp = tt;
            step += 1;
        }

        return -1;
    }
}
