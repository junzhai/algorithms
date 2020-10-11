package com.leetcode.algorithms.xxx_tallestBillboard_956;

import com.leetcode.algorithms.pattern.BFS;
import com.leetcode.algorithms.pattern.DP;

import java.util.Arrays;

@BFS
@DP
public class BFSandDP2 extends Solution {
    @Override
    public int tallestBillboard(int[] rods) {
        int max = 0;
        for (int r : rods) {
            max += r;
        }

        int[] dp = new int[max + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        int r = 0;
        for (int rod : rods) {
            int[] copy = Arrays.copyOfRange(dp, 0, r + 1);
            for (int i = 0; i <= r; i++) {
                if (copy[i] < 0) {
                    continue;
                }

                dp[i + rod] = Math.max(dp[i + rod], copy[i]);
                if(rod <= i){
                    dp[i - rod] = Math.max(dp[i - rod], copy[i] + rod);
                } else {
                    dp[rod - i] = Math.max(dp[rod - i], copy[i] + i);
                }
            }
            r += rod;
        }

        return dp[0];
    }
}
