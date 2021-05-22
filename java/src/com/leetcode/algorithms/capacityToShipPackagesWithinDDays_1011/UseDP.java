package com.leetcode.algorithms.capacityToShipPackagesWithinDDays_1011;

import com.pattern.algorithms.DP;

@DP
/**
 * Time Limit Exceeded
 */
public class UseDP extends Solution {
    @Override
    public int shipWithinDays(int[] weights, int D) {
        int len = weights.length;
        int[] dp0 = new int[len], dp1 = new int[len];
        for (int i = 0, s = 0; i < len; i++) {
            s += weights[i];
            dp0[i] = s;
        }

        for (int d = 2; d <= D; d++) {
            for (int i = 0; i < len; i++) {
                dp1[i] = dp0[i];
                for (int j = i - 1, s = weights[i]; j >= 0; j--) {
                    if (dp0[j] > s) {
                        dp1[i] = Math.min(dp1[i], dp0[j]);
                        s += weights[j];
                    } else {
                        dp1[i] = Math.min(dp1[i], s);
                        break;
                    }
                }
            }
            int[] tmp = dp0;
            dp0 = dp1;
            dp1 = tmp;
        }

        return dp0[len - 1];
    }
}
