package com.leetcode.algorithms.raceCar_818_xxx;

import java.util.Arrays;

/**
 * Time Limit Exceeded
 */
public class Recursive extends Solution {
    @Override
    public int racecar(int target) {
        int max = target + target / 2;
        int[] dp = new int[max + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        helper(target, dp, 0, false, -2);
        return dp[target];
    }

    private void helper(int target, int[] dp, int pos, boolean direction, int op) {
        dp[pos] = op;
        int len = dp.length;

        for (int speed = 1, np = pos, nop = op + (direction ? 1 : 2); np + speed < len; speed <<= 1) {
            nop += 1;
            np += speed;
            if (nop <= dp[np] && nop < dp[target]) {
                helper(target, dp, np, false, nop);
            }
        }

        for (int speed = -1, np = pos, nop = op + (direction ? 2 : 1); np + speed > 0; speed <<= 1) {
            nop += 1;
            np += speed;
            if (nop <= dp[np] && nop < dp[target]) {
                helper(target, dp, np, true, nop);
            }
        }
    }
}