package com.leetcode.algorithms.minimumNumberOfRefuelingStops_871;

import com.pattern.algorithms.DP;

@DP
public class UsingDP1 extends Solution {
    @Override
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (target <= startFuel) {
            return 0;
        }

        int len = stations.length;
        if (len == 0 || startFuel < stations[0][0]) {
            return -1;
        }

        int[][] dp0 = new int[len][2], dp1 = new int[len][2];
        dp0[0][1] = startFuel - stations[0][0];
        int l = 1;

        for (int i = 1; i < len; i++) {
            if (l == 0) {
                return -1;
            }

            int ll = 0, gas = stations[i - 1][1], dist = stations[i][0] - stations[i - 1][0];
            for (int j = 0; j < l; j++) {
                int count = dp0[j][0], left = dp0[j][1];
                boolean y = false;
                dp1[ll][1] = 0;
                if (left >= dist) {
                    dp1[ll][0] = count;
                    dp1[ll][1] = left - dist;
                    y = true;
                }

                if (j > 0 && dp0[j - 1][0] == count - 1 && dp0[j - 1][1] + gas >= dist) {
                    dp1[ll][0] = count;
                    dp1[ll][1] = Math.max(dp1[ll][1], dp0[j - 1][1] + gas - dist);
                    y = true;
                }

                if (y) {
                    ll += 1;
                }
            }

            if (dp0[l - 1][1] + gas >= dist) {
                dp1[ll][0] = dp0[l - 1][0] + 1;
                dp1[ll][1] = dp0[l - 1][1] + gas - dist;
                ll += 1;
            }

            int[][] tmp = dp0;
            dp0 = dp1;
            dp1 = tmp;
            l = ll;
        }

        int t = target - stations[len - 1][0];
        for (int i = 0; i < l; i++) {
            if (dp0[i][1] >= t) {
                return dp0[i][0];
            }
            if (dp0[i][1] + stations[len - 1][1] >= t) {
                return dp0[i][0] + 1;
            }
        }
        return -1;
    }
}
