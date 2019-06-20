package com.leetcode.algorithms.xxx_tallestBillboard_956;

import com.leetcode.algorithms.pattern.BFS;
import com.leetcode.algorithms.pattern.DP;

import java.util.Arrays;

@BFS
@DP
public class BFSandDP extends Solution {
    @Override
    public int tallestBillboard(int[] rods) {
        int max = 0;
        for (int r : rods) {
            max += r;
        }

        int[] dp = new int[(max << 1) + 1];
        Arrays.fill(dp, -1);
        dp[max] = 0;

        int l = max, r = max;
        for (int rod : rods) {
            int[] copy = Arrays.copyOfRange(dp, l, r + 1);
            for (int i = l; i <= r; i++) {
                if (copy[i - l] < 0) {
                    continue;
                }

                dp[i + rod] = Math.max(dp[i + rod], copy[i - l] + rod);
                dp[i - rod] = Math.max(dp[i - rod], copy[i - l]);
            }
            r += rod;
            l -= rod;
        }

        return dp[max];
    }
}
