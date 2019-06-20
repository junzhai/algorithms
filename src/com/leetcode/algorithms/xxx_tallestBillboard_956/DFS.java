package com.leetcode.algorithms.xxx_tallestBillboard_956;

/**
 * Time Limit Exceeded
 */
public class DFS extends Solution {
    @Override
    public int tallestBillboard(int[] rods) {
        int len = rods.length;
        int[] suffix = new int[len];
        for (int i = len - 1, s = 0; i >= 0; i--) {
            s += rods[i];
            suffix[i] = s;
        }
        return helper(rods, suffix, 0, 0, 0);
    }

    private int helper(int[] rods, int[] suffix, int i, int tall, int sum) {
        int len = rods.length;
        if (i >= len) {
            return sum == 0 ? tall : 0;
        }

        if (sum + suffix[i] < 0 || sum - suffix[i] > 0) {
            return 0;
        }

        int ret = helper(rods, suffix, i + 1, tall + rods[i], sum + rods[i]);
        ret = Math.max(ret, helper(rods, suffix, i + 1, tall, sum));
        ret = Math.max(ret, helper(rods, suffix, i + 1, tall, sum - rods[i]));
        return ret;
    }
}
